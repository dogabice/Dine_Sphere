package com.dinesphere.dtos;

public class TablesDTO { // İsimlendirme 'Table' olarak düzeltildi.
    private Long tableId;
    private Integer capacity;
    private Boolean occupied; // 'isOccupied' yerine 'occupied' tercih edildi

    // Getters and Setters
    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getOccupied() { // Daha sade isimlendirme
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}
