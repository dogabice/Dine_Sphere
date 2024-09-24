package com.dinesphere.repositories;

import com.dinesphere.entities.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    Ingredients findByIngredientsId(Long id); 
}
