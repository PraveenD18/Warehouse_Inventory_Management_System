package com.wims.service;
import com.wims.dto.request.CreateInventoryRequest;
import com.wims.dto.response.InventoryResponse;

import java.util.List;

public interface InventoryService {

    InventoryResponse createInventory(CreateInventoryRequest request);

    List<InventoryResponse> getAllInventory();

    InventoryResponse getInventoryById(Long id);

    List<InventoryResponse> getInventoryByItem(Long itemId);

    InventoryResponse updateInventory(Long id, CreateInventoryRequest request);

    void deleteInventory(Long id);
}

