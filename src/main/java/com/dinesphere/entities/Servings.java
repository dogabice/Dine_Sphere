package com.dinesphere.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import lombok.Data;


@Data
@Entity
@Table(name = "servings")
public class Servings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servingId;

    @ManyToOne
    @JoinColumn(name = "tableId", referencedColumnName = "tableId", nullable = false)
    private Tables table;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

}
