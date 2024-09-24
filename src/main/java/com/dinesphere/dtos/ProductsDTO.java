package com.dinesphere.dtos;

import java.util.List;

public class ProductsDTO {
    private Long productsId;
    private String name;
    private Double price;
    private List<Long> ingredientIds; 

    // Getters and Setters
    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long id) {
        this.productsId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}
