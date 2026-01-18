package com.wims.service.impl;

import com.wims.dto.request.CreateInventoryRequest;
import com.wims.dto.response.InventoryResponse;
import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;
import com.wims.mapper.InventoryMapper;
import com.wims.repository.InventoryRepository;
import com.wims.repository.ItemRepository;
import com.wims.repository.LocationRepository;
import com.wims.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;
    private final LocationRepository locationRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository,
                                ItemRepository itemRepository,
                                LocationRepository locationRepository,
                                InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.itemRepository = itemRepository;
        this.locationRepository = locationRepository;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public InventoryResponse createInventory(CreateInventoryRequest request) {
        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        Location bin = locationRepository.findById(request.getBinId())
                .orElseThrow(() -> new RuntimeException("Bin not found"));

        Inventory inventory = inventoryMapper.toEntity(request, item, bin);
        return inventoryMapper.toResponse(inventoryRepository.save(inventory));
    }

    @Override
    public List<InventoryResponse> getAllInventory() {
        return inventoryRepository.findAll()
                .stream()
                .map(inventoryMapper::toResponse)
                .toList();
    }

    @Override
    public InventoryResponse getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        return inventoryMapper.toResponse(inventory);
    }

    @Override
    public List<InventoryResponse> getInventoryByItem(Long itemId) {
        return inventoryRepository.findByItemId(itemId)
                .stream()
                .map(inventoryMapper::toResponse)
                .toList();
    }

    @Override
    public InventoryResponse updateInventory(Long id, CreateInventoryRequest request) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventoryMapper.updateEntity(inventory, request);
        return inventoryMapper.toResponse(inventoryRepository.save(inventory));
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
