package com.dinesphere.services;

import com.dinesphere.dtos.IngredientsDTO;
import com.dinesphere.entities.Ingredients;
import com.dinesphere.mappers.IngredientsMapper;
import com.dinesphere.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    public IngredientsDTO createIngredient(IngredientsDTO ingredientsDTO) {
        Ingredients ingredient = IngredientsMapper.toEntity(ingredientsDTO);
        Ingredients savedIngredient = ingredientsRepository.save(ingredient);
        return IngredientsMapper.toDTO(savedIngredient);
    }

    public Optional<IngredientsDTO> getIngredient(Long id) {
        return ingredientsRepository.findById(id).map(IngredientsMapper::toDTO);
    }

    public void deleteIngredient(Long id) {
        ingredientsRepository.deleteById(id);
    }

}
