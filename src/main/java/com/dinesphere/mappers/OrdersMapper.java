package com.dinesphere.mappers;

import com.dinesphere.dtos.OrdersDTO;
import com.dinesphere.entities.Orders;
import com.dinesphere.entities.Products;
import com.dinesphere.entities.Servings;
import com.dinesphere.entities.Tables;

import java.util.List;
import java.util.stream.Collectors;

public class OrdersMapper {

    public static OrdersDTO toDTO(Orders order) {
        OrdersDTO dto = new OrdersDTO();
        dto.setOrderId(order.getOrderId());
        dto.setTableId(order.getTable().getTableId()); 
        dto.setServingId(order.getServings().getServingId()); 
        dto.setProductIds(order.getProducts().stream()
                                 .map(Products::getProductId) 
                                 .collect(Collectors.toList()));
        dto.setOrderTime(order.getOrderDate());
        return dto;
    }

    public static Orders toEntity(OrdersDTO dto, Tables table, Servings servings, List<Products> products) {
        Orders order = new Orders();
        order.setOrderId(dto.getOrderId());
        order.setTable(table); 
        order.setServings(servings); 
        order.setProducts(products);
        order.setOrderDate(dto.getOrderTime());
        return order;
    }
}
