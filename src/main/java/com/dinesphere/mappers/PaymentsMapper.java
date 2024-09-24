package com.dinesphere.mappers;

import com.dinesphere.dtos.PaymentsDTO;
import com.dinesphere.entities.Payments;
import com.dinesphere.entities.Orders;
import java.time.LocalDateTime;

public class PaymentsMapper {

    public static PaymentsDTO toDTO(Payments payment) {
        PaymentsDTO dto = new PaymentsDTO();
        dto.setPaymentId(payment.getPaymentId());
        dto.setOrderId(payment.getOrder().getOrderId());
        dto.setAmount(payment.getAmount());
        return dto;
    }

    public static Payments toEntity(PaymentsDTO dto, Orders order) {
        Payments payment = new Payments();
        payment.setOrder(order); // Sipariş bilgisi dışarıdan veriliyor
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(LocalDateTime.now()); // Ödeme tarihi şu an
        return payment;
    }
}
