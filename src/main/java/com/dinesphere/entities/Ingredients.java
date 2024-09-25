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
    private Long ingredientsId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double quantity;

    @ManyToMany(mappedBy = "ingredients")
    private List<Products> products; // Malzemenin ait olduğu ürünler

    // Getters and Setters
    public Long getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(Long id) {
        this.ingredientsId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}
