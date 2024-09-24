package com.dinesphere.repositories;

import com.dinesphere.entities.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TablesRepository extends JpaRepository<Tables, Long> {
    
    Tables findByTableId(Long tableId);
    
}
