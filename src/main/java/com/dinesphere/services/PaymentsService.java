package com.dinesphere.services;

import com.dinesphere.dtos.PaymentsDTO;
import com.dinesphere.entities.Payments;
import com.dinesphere.entities.Orders;
import com.dinesphere.mappers.PaymentsMapper;
import com.dinesphere.repositories.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentsService {

    @Autowired
    private final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    public PaymentsDTO createPayment(PaymentsDTO paymentsDTO, Orders order) {
        Payments payment = PaymentsMapper.toEntity(paymentsDTO, order);
        Payments savedPayment = paymentsRepository.save(payment);
        return PaymentsMapper.toDTO(savedPayment);
    }
}
