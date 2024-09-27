package com.dinesphere.mappers;

import com.dinesphere.entities.Tables;
import com.dinesphere.dtos.TablesDTO;

public class TablesMapper {
    public static TablesDTO toDTO(Tables table) {
        TablesDTO dto = new TablesDTO();
        dto.setTableId(table.getTableId());
        dto.setCapacity(table.getCapacity());
        dto.setOccupied(table.getIsOccupied());
        return dto;
    }

    public static Tables toEntity(TablesDTO dto) {
        Tables table = new Tables();
        table.setTableId(dto.getTableId());
        table.setCapacity(dto.getCapacity());
        table.setIsOccupied(dto.getOccupied());
        return table;
    }
}
