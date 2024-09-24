package com.dinesphere.mappers;

import com.dinesphere.dtos.ProductsDTO;
import com.dinesphere.entities.Products;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsMapper {

    public static ProductsDTO toDTO(Products product) {
        ProductsDTO dto = new ProductsDTO();
        dto.setProductsId(product.getProductsId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        // Malzemeleri ID'leriyle eşleştir
        List<Long> ingredientIds = product.getIngredients().stream()
                                           .map(ingredient -> ingredient.getIngredientsId())
                                           .collect(Collectors.toList());
        dto.setIngredientIds(ingredientIds);
        return dto;
    }

    public static Products toEntity(ProductsDTO dto) {
        Products product = new Products();
        product.setProductsId(dto.getProductsId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        // Malzemeleri ID'leriyle eşleştir
        // Burada ingredient nesnelerini oluşturup set etmelisin
        return product;
    }
}