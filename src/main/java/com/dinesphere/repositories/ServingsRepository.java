package com.dinesphere.repositories;

import com.dinesphere.entities.Servings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServingsRepository extends JpaRepository<Servings, Long> {
    Servings findByServingId(Long id); 
}
