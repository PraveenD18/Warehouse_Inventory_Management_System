package com.wims.controller;

import com.wims.dto.request.CreateStockMovementRequest;
import com.wims.dto.response.StockMovementResponse;
import com.wims.service.StockMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-movements")
public class StockMovementController {

    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @PostMapping
    public ResponseEntity<StockMovementResponse> create(
            @RequestBody CreateStockMovementRequest request) {
        return ResponseEntity.ok(stockMovementService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<StockMovementResponse>> getAll() {
        return ResponseEntity.ok(stockMovementService.getAll());
    }
}
