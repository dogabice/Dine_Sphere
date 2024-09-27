package com.dinesphere.dtos;

import java.util.List;

public class ProductsDTO { // İsimlendirme 'Product' olarak düzeltildi.
    private Long productId; // 'productsId' yerine 'productId' olmalı
    private String name;
    private Double price;
    private List<Long> ingredientIds; 

    // Getters and Setters
    public Long getProductsId() {
        return productId;
    }

    public void setProductsId(Long productId) { // Düzeltme yapıldı
        this.productId = productId;
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

    public List<Long> getIngredientsIds() {
        return ingredientIds;
    }

    public void setIngredientsIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}

