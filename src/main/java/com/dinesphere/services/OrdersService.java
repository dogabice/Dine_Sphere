package com.dinesphere.services;

import com.dinesphere.dtos.OrdersDTO;
import com.dinesphere.entities.Orders;
import com.dinesphere.entities.Products;
import com.dinesphere.entities.Servings;
import com.dinesphere.entities.Tables;
import com.dinesphere.mappers.OrdersMapper;
import com.dinesphere.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getOrdersByServings(Servings servings) {
        return ordersRepository.findByServings(servings); // Düzeltme
    }

    public OrdersDTO createOrder(OrdersDTO orderDTO, Tables table, Servings servings, List<Products> products) {
        Orders order = OrdersMapper.toEntity(orderDTO, table, servings, products);
        Orders savedOrder = ordersRepository.save(order);
        return OrdersMapper.toDTO(savedOrder);
    }

    public List<OrdersDTO> getOrdersByTableId(Long id) {
        List<Orders> orders = ordersRepository.findByTable_TableId(id);
        return orders.stream()
                     .map(OrdersMapper::toDTO)
                     .toList();
    }

    public List<OrdersDTO> getOrdersByServingId(Long id) {
        List<Orders> orders = ordersRepository.findByServings_ServingId(id);
        return orders.stream()
                     .map(OrdersMapper::toDTO)
                     .toList();
    }

    public OrdersDTO getOrderById(Long id) {
        Orders order = ordersRepository.findById(id).orElse(null);
        return order != null ? OrdersMapper.toDTO(order) : null;
    }

    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
