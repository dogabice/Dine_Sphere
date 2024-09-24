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

    public OrdersDTO createOrder(OrdersDTO orderDTO, Tables table, Servings servings, List<Products> products) {
        Orders order = OrdersMapper.toEntity(orderDTO, table, servings, products);
        Orders savedOrder = ordersRepository.save(order);
        return OrdersMapper.toDTO(savedOrder);
    }

    public List<OrdersDTO> getOrdersByTableId(Long tableId) {
        List<Orders> orders = ordersRepository.findByTableId(tableId);
        return orders.stream()
                     .map(OrdersMapper::toDTO)
                     .toList();
    }

    public List<OrdersDTO> getOrdersByServingId(Long servingId) {
        List<Orders> orders = ordersRepository.findByServingId(servingId);
        return orders.stream()
                     .map(OrdersMapper::toDTO)
                     .toList();
    }

    public OrdersDTO getOrderById(Long orderId) {
        Orders order = ordersRepository.findById(orderId).orElse(null);
        return order != null ? OrdersMapper.toDTO(order) : null;
    }

    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}
