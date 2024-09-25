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
    @JoinColumn(name = "table_id", nullable = false)
    private Tables table; // Siparişin ait olduğu masa

    @ManyToOne
    @JoinColumn(name = "serving_id", nullable = false)
    private Servings servings; // Siparişin ait olduğu servis

    @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> products; // Siparişteki ürünler

    @Column(nullable = false)
    private LocalDateTime orderDate;

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long id) {
        this.orderId = id;
    }

    public Tables getTable() {
        return table;
    }

    public void setTable(Tables table) {
        this.table = table;
    }

    public Servings getServings() {
        return servings;
    }

    public void setServings(Servings servings) {
        this.servings = servings;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
