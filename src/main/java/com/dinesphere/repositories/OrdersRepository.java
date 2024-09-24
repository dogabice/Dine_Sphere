package com.dinesphere.repositories;

import com.dinesphere.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByTableId(Long tableId); 
    List<Orders> findByServingId(Long servingId);
}
