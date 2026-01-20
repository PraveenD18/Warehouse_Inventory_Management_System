package com.wims.controller;

import com.wims.dto.request.CreateSalesOrderRequest;
import com.wims.dto.response.SalesOrderResponse;
import com.wims.service.SalesOrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

    private final SalesOrderService service;

    public SalesOrderController(SalesOrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SalesOrderResponse> create(
            @Valid @RequestBody CreateSalesOrderRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<SalesOrderResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
