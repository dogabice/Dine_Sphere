package com.dinesphere.entities;

import jakarta.persistence.*;
import java.util.List;

import lombok.Data;


@Data
@Entity
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double quantity;

    @ManyToMany(mappedBy = "ingredientsList")
    private List<Products> productList; // Ürünlerin bu malzemeyi kullandığı ilişkiler
}

