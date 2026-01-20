package com.wims.service;

import com.wims.dto.request.CreateStockMovementRequest;
import com.wims.dto.response.StockMovementResponse;

import java.util.List;

public interface StockMovementService {

    StockMovementResponse create(CreateStockMovementRequest request);
    List<StockMovementResponse> getAll();
}
