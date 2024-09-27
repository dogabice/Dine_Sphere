package com.dinesphere.services;

import com.dinesphere.dtos.TablesDTO;
import com.dinesphere.entities.Orders;
import com.dinesphere.entities.Servings;
import com.dinesphere.entities.Tables;
import com.dinesphere.mappers.TablesMapper;
import com.dinesphere.repositories.OrdersRepository;
import com.dinesphere.repositories.ServingsRepository;
import com.dinesphere.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;

    @Autowired
    private ServingsRepository servingsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public TablesDTO createTable(TablesDTO tableDTO) {
        Tables table = TablesMapper.toEntity(tableDTO);
        Tables savedTable = tablesRepository.save(table);
        return TablesMapper.toDTO(savedTable);
    }

    public Optional<TablesDTO> getTable(Long id) {
        return tablesRepository.findById(id).map(TablesMapper::toDTO);
    }

    public boolean deleteTable(Long id) {
        if (tablesRepository.existsById(id)) {
            tablesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    

    public boolean openServingForTable(Long tableId) {
        Optional<Tables> tableOptional = tablesRepository.findById(tableId);
        if (tableOptional.isPresent()) {
            Tables table = tableOptional.get();
            Servings newServing = new Servings();
            newServing.setTable(table);
            newServing.setStartTime(LocalDateTime.now());
            servingsRepository.save(newServing);
            return true;
        } else {
            return false;
        }
    }

    public List<TablesDTO> getAllTables() {
        List<Tables> tablesList = tablesRepository.findAll();
        return tablesList.stream()
                         .map(TablesMapper::toDTO)
                         .collect(Collectors.toList());
    }

    public String generateEndOfDayReport() {
        List<Tables> tables = tablesRepository.findAll();
        StringBuilder report = new StringBuilder("End of Day Report:\n");
        for (Tables table : tables) {
            report.append("Table ID: ").append(table.getTableId()).append("\n");
            List<Servings> servings = servingsRepository.findByTable(table);
            for (Servings serving : servings) {
                report.append("  Serving ID: ").append(serving.getServingId()).append(", Start Time: ").append(serving.getStartTime()).append("\n");
                List<Orders> orders = ordersRepository.findByServings(serving);
                for (Orders order : orders) {
                    report.append("    Order ID: ").append(order.getOrderId()).append(", Order Date: ").append(order.getOrderDate()).append("\n");
                }
            }
            report.append("\n");
        }
        return report.toString();
    }

    public Optional<TablesDTO> updateTable(Long id, TablesDTO tableDTO) {
        return tablesRepository.findById(id)
                .map(existingTable -> {
                    existingTable.setCapacity(tableDTO.getCapacity());
                    existingTable.setIsOccupied(tableDTO.getOccupied());
                    // Diğer alanlar güncellenebilir
                    Tables updatedTable = tablesRepository.save(existingTable);
                    return TablesMapper.toDTO(updatedTable);
                });
    }
}
