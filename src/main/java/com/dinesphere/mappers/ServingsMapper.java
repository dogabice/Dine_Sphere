package com.dinesphere.mappers;

import com.dinesphere.entities.Servings;
import com.dinesphere.entities.Tables;
import com.dinesphere.dtos.ServingsDTO;

public class ServingsMapper {
    public static ServingsDTO toDTO(Servings serving) {
        ServingsDTO dto = new ServingsDTO();
        dto.setServingId(serving.getServingId());
        dto.setTableId(serving.getTable().getTableId());
        dto.setStartTime(serving.getStartTime());
        dto.setEndTime(serving.getEndTime());
        return dto;
    }

    public static Servings toEntity(ServingsDTO dto) {
        Servings serving = new Servings();
        serving.setServingId(dto.getServingId());
        serving.setStartTime(dto.getStartTime());
        serving.setEndTime(dto.getEndTime());
        // --------------------------------------------
        Tables table = new Tables();
        table.setTableId(dto.getTableId());
        serving.setTable(table);
        return serving;
    }
}
