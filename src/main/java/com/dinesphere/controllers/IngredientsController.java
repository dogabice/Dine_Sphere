package com.dinesphere.controllers;

import com.dinesphere.dtos.IngredientsDTO;
import com.dinesphere.services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {
    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping
    public ResponseEntity<IngredientsDTO> createIngredient(@RequestBody IngredientsDTO ingredientsDTO) {
        IngredientsDTO createdIngredient = ingredientsService.createIngredient(ingredientsDTO);
        return new ResponseEntity<>(createdIngredient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientsDTO> getIngredient(@PathVariable Long id) {
        Optional<IngredientsDTO> ingredientsDTO = ingredientsService.getIngredient(id);
        return ingredientsDTO.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        ingredientsService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }

}
