package com.wims.service;

import com.wims.dto.request.CreateSalesOrderRequest;
import com.wims.dto.response.SalesOrderResponse;

import java.util.List;

public interface SalesOrderService {

    SalesOrderResponse create(CreateSalesOrderRequest request);

    List<SalesOrderResponse> getAll();
}
