package com.dinesphere.controllers;

import com.dinesphere.dtos.TablesDTO;
import com.dinesphere.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/tables")
public class TablesController {
    @Autowired
    private TablesService tablesService;

    @PostMapping
    public ResponseEntity<TablesDTO> createTable(@RequestBody TablesDTO tableDTO) {
        TablesDTO createdTable = tablesService.createTable(tableDTO);
        return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TablesDTO> getTable(@PathVariable Long id) {
        Optional<TablesDTO> tableDTO = tablesService.getTable(id);
        return tableDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tablesService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

}
