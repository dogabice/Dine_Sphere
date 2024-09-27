package com.dinesphere.dtos;

public class IngredientsDTO { // 'Ingredient' olarak düzeltildi
    private Long ingredientId; // 'ingredientsId' yerine 'ingredientId' olmalı
    private String name;
    private Double quantity;

    // Getters and Setters
    public Long getIngredientsId() {
        return ingredientId;
    }

    public void setIngredientsId(Long ingredientId) { // İsim düzeltildi
        this.ingredientId = ingredientId;
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
