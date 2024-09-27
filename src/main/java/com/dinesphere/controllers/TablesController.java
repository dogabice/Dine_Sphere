package com.dinesphere.controllers;

import com.dinesphere.dtos.TablesDTO;
import com.dinesphere.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    private final TablesService tablesService;

    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @Operation(summary = "Get All Tables")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success")
    })
    @GetMapping
    public ResponseEntity<List<TablesDTO>> getAllTables() {
        List<TablesDTO> tables = tablesService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @Operation(summary = "Get Table By ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "404", description = "Table cannot be found.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TablesDTO> getTableById(@PathVariable Long id) {
        Optional<TablesDTO> table = tablesService.getTable(id);
        return table.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Create new Table")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Created successfully.")
    })
    @PostMapping
    public ResponseEntity<TablesDTO> createTable(@RequestBody TablesDTO tableDTO) {
        TablesDTO newTable = tablesService.createTable(tableDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTable);
    }

    @Operation(summary = "Update Table")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated successfully."),
        @ApiResponse(responseCode = "404", description = "Table cannot be found.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TablesDTO> updateTable(@PathVariable Long id, @RequestBody TablesDTO tableDTO) {
        Optional<TablesDTO> updatedTable = tablesService.updateTable(id, tableDTO);
        return updatedTable.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Delete Table By ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Success"),
        @ApiResponse(responseCode = "404", description = "Table cannot be found.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        if (tablesService.deleteTable(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
