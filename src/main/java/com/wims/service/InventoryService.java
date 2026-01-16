package com.wims.service;

import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;

public interface InventoryService {

    Inventory addStock(Item item, Location bin, int qty);

    void reserveStock(Inventory inventory, int qty);
}
