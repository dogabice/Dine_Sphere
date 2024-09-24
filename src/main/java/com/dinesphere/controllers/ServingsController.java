package com.dinesphere.controllers;

import com.dinesphere.dtos.ServingsDTO;
import com.dinesphere.services.ServingsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/servings")
public class ServingsController {
    @Autowired
    private ServingsService servingService;

    @PostMapping
    public ResponseEntity<ServingsDTO> createServing(@RequestBody ServingsDTO servingDTO) {
        ServingsDTO createdServing = servingService.createServing(servingDTO);
        return new ResponseEntity<>(createdServing, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServingsDTO> getServing(@PathVariable Long id) {
        Optional<ServingsDTO> servingDTO = servingService.getServing(id);
        return servingDTO.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServing(@PathVariable Long id) {
        servingService.deleteServing(id);
        return ResponseEntity.noContent().build();
    }

}
