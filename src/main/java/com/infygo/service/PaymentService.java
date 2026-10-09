package com.infygo.service;

import com.infygo.dto.PaymentDTO;

public interface PaymentService {

    String makePayment(PaymentDTO paymentDTO);
}