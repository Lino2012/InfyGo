package com.infygo.service;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.dto.PaymentDTO;
import com.infygo.entity.Payment;
import com.infygo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl
        implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public String makePayment(
            PaymentDTO dto) {

        if(dto.getCardNumber().length() != 16)
            throw new RuntimeException(
                    "Card number should be 16 digits");

        if(dto.getCvv().toString().length() != 3)
            throw new RuntimeException(
                    "CVV should be 3 digits");

        if(dto.getExpiryYear()
                < Year.now().getValue())
            throw new RuntimeException(
                    "Card Expired");

        Payment payment = new Payment();

        payment.setCardHolderName(
                dto.getCardHolderName());

        payment.setCardNumber(
                dto.getCardNumber());

        payment.setExpiryMonth(
                dto.getExpiryMonth());

        payment.setExpiryYear(
                dto.getExpiryYear());

        payment.setCvv(
                dto.getCvv());

        payment.setAmount(
                dto.getAmount());

        paymentRepository.save(payment);

        return "Payment Successful";
    }
}