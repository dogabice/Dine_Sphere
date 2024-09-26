package com.dinesphere.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "tableId",nullable = false)
    private Tables table; // Siparişin ait olduğu masa


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "servingId",nullable = false)
    private Servings servings; // Siparişin ait olduğu servis

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "orderId"),
        inverseJoinColumns = @JoinColumn(name = "productsId")
    )
    private List<Products> products; // Siparişteki ürünler

    @Column(nullable = false)
    private LocalDateTime orderDate;

}
