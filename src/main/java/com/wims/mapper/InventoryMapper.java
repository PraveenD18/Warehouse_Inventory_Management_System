package com.wims.mapper;
import com.wims.dto.request.CreateInventoryRequest;
import com.wims.dto.response.InventoryResponse;
import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {

    public Inventory toEntity(CreateInventoryRequest request, Item item, Location bin) {
        Inventory inventory = new Inventory();
        inventory.setItem(item);
        inventory.setBin(bin);
        inventory.setQtyOnHand(request.getQtyOnHand());
        inventory.setQtyReserved(request.getQtyReserved());
        return inventory;
    }

    public void updateEntity(Inventory inventory, CreateInventoryRequest request) {
        inventory.setQtyOnHand(request.getQtyOnHand());
        inventory.setQtyReserved(request.getQtyReserved());
    }

    public InventoryResponse toResponse(Inventory inventory) {
        InventoryResponse response = new InventoryResponse();
        response.setId(inventory.getId());
        response.setItemId(inventory.getItem().getId());
        response.setBinId(inventory.getBin().getId());
        response.setQtyOnHand(inventory.getQtyOnHand());
        response.setQtyReserved(inventory.getQtyReserved());
        return response;
    }
}
