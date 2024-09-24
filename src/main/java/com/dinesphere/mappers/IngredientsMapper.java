package com.dinesphere.mappers;

import com.dinesphere.dtos.IngredientsDTO;
import com.dinesphere.entities.Ingredients;

public class IngredientsMapper {

    public static IngredientsDTO toDTO(Ingredients ingredient) {
        IngredientsDTO dto = new IngredientsDTO();
        dto.setIngredientsId(ingredient.getIngredientsId());
        dto.setName(ingredient.getName());
        dto.setQuantity(ingredient.getQuantity());
        return dto;
    }

    public static Ingredients toEntity(IngredientsDTO dto) {
        Ingredients ingredient = new Ingredients();
        ingredient.setIngredientsId(dto.getIngredientsId());
        ingredient.setName(dto.getName());
        ingredient.setQuantity(dto.getQuantity());
        return ingredient;
    }
}
