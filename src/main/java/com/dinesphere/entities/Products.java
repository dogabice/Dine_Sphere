package com.dinesphere.entities;

import jakarta.persistence.*;
import java.util.List;

import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "ingredients_id")
    private Ingredients ingredients;

    @ManyToMany
    @JoinTable(
        name = "product_ingredient",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredients> ingredient; // Ürünle ilişkili malzemeler
}

