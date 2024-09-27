package com.dinesphere.dtos;

import java.time.LocalDateTime;

public class ServingsDTO {
    private Long servingId;
    private Long tableId; 
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Getters and Setters
    public Long getServingId() {
        return servingId;
    }

    public void setServingId(Long servingId) {
        this.servingId = servingId;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
