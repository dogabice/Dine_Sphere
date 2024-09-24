package com.dinesphere.dtos;

public class IngredientsDTO {
    private Long ingredientsId;
    private String name;
    private Double quantity;

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
}
