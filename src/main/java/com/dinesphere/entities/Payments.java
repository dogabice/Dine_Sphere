package com.dinesphere.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;


@Data
@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Orders order; 

    @Column(nullable = false)
    private Double amount; // Check

    @Column(nullable = false)
    private LocalDateTime paymentDate; // Check date
}
