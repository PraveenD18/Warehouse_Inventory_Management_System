package com.wims.service;

import com.wims.dto.request.CreatePurchaseOrderRequest;
import com.wims.dto.response.PurchaseOrderResponse;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderResponse createPurchaseOrder(CreatePurchaseOrderRequest request);
    List<PurchaseOrderResponse> getAllPurchaseOrders();
    PurchaseOrderResponse getPurchaseOrderById(Long id);
}
