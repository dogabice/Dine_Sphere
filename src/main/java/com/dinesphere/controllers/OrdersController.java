package com.dinesphere.controllers;

import com.dinesphere.dtos.OrdersDTO;
import com.dinesphere.entities.Products;
import com.dinesphere.entities.Servings;
import com.dinesphere.entities.Tables;
import com.dinesphere.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private final OrdersService ordersService;

    
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO orderDTO,
                                                  @RequestParam Long tableId,
                                                  @RequestParam Long servingId,
                                                  @RequestBody List<Products> products) {
        Tables table = new Tables();
        table.setTableId(tableId); // Masayı ayarla

        Servings servings = new Servings();
        servings.setServingId(servingId); // Servisi ayarla

        OrdersDTO createdOrder = ordersService.createOrder(orderDTO, table, servings, products);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrdersDTO> getOrderById(@PathVariable Long orderId) {
        OrdersDTO order = ordersService.getOrderById(orderId);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @GetMapping("/table/{tableId}")
    public ResponseEntity<List<OrdersDTO>> getOrdersByTableId(@PathVariable Long tableId) {
        List<OrdersDTO> orders = ordersService.getOrdersByTableId(tableId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/serving/{servingId}")
    public ResponseEntity<List<OrdersDTO>> getOrdersByServingId(@PathVariable Long servingId) {
        List<OrdersDTO> orders = ordersService.getOrdersByServingId(servingId);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        ordersService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
