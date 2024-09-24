package com.dinesphere.services;

import com.dinesphere.dtos.TablesDTO;
import com.dinesphere.entities.Tables;
import com.dinesphere.mappers.TablesMapper;
import com.dinesphere.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;

    public TablesDTO createTable(TablesDTO tableDTO) {
        Tables table = TablesMapper.toEntity(tableDTO);
        Tables savedTable = tablesRepository.save(table);
        return TablesMapper.toDTO(savedTable);
    }

    public Optional<TablesDTO> getTable(Long id) {
        return tablesRepository.findById(id).map(TablesMapper::toDTO);
    }

    public void deleteTable(Long id) {
        tablesRepository.deleteById(id);
    }

}
