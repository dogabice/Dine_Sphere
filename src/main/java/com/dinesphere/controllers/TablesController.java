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
@RequestMapping("/api/tables")
public class TablesController {
    @Autowired
    private TablesService tablesService;

    @Operation(summary = "Create a new table")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Table created"),
        @ApiResponse(responseCode = "400", description = "Invalid input") })
    @PostMapping
    public ResponseEntity<TablesDTO> createTable(@RequestBody TablesDTO tableDTO) {
        TablesDTO createdTable = tablesService.createTable(tableDTO);
        return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
    }

    @Operation(summary = "Get table by ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Found the table"),
        @ApiResponse(responseCode = "404", description = "Table not found") })
    @GetMapping("/{id}")
    public ResponseEntity<TablesDTO> getTable(@PathVariable Long id) {
        Optional<TablesDTO> tableDTO = tablesService.getTable(id);
        return tableDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a table by ID")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Table deleted") })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tablesService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Open serving for a table")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Serving opened"),
        @ApiResponse(responseCode = "409", description = "Conflict occurred") })
    @PostMapping("/{tableId}/servings")
    public ResponseEntity<Void> openServing(@PathVariable Long tableId) {
        boolean isServingOpened = tablesService.openServingForTable(tableId);
        if (isServingOpened) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @Operation(summary = "Get all tables")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "List of tables") })
    @GetMapping
    public ResponseEntity<List<TablesDTO>> getAllTables() {
        List<TablesDTO> tables = tablesService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @Operation(summary = "Generate end of day report")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "End of day report") })
    @GetMapping("/report")
    public ResponseEntity<String> endOfDayReport() {
        String report = tablesService.generateEndOfDayReport();
        return ResponseEntity.ok(report);
    }
}

