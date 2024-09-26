package com.dinesphere.repositories;

import com.dinesphere.entities.Orders;
import com.dinesphere.entities.Servings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByTable_TableId(Long tableId);
    List<Orders> findByServings_ServingId(Long servingId);
    List<Orders> findByServings(Servings servings);
    
}
