package com.dinesphere.controllers;

import com.dinesphere.dtos.PaymentsDTO;
import com.dinesphere.entities.Orders;
import com.dinesphere.services.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {

    @Autowired
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @PostMapping
    public ResponseEntity<PaymentsDTO> createPayment(@RequestBody PaymentsDTO paymentsDTO,
                                                     @RequestParam Long orderId) {
        Orders order = new Orders(); // Siparişin gerçek nesnesi burada bulunmalı
        order.setOrderId(orderId); // Sipariş ID'sini ayarla

        PaymentsDTO createdPayment = paymentsService.createPayment(paymentsDTO, order);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }
}
