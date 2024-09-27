package com.dinesphere.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class OrdersDTO { // İsimlendirme 'Order' olarak düzeltildi.
    private Long orderId;
    private Long tableId; 
    private Long servingId; 
    private List<Long> productIds; 
    private LocalDateTime orderDate; // 'orderTime' yerine 'orderDate'

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getServingId() {
        return servingId;
    }

    public void setServingId(Long servingId) {
        this.servingId = servingId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public LocalDateTime getOrderDate() { // Düzeltildi
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
