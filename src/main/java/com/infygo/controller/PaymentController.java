package com.infygo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infygo.dto.PaymentDTO;
import com.infygo.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/infygo/payment")
    public String makePayment(
            @RequestBody PaymentDTO dto) {

        return paymentService
                .makePayment(dto);
    }
}