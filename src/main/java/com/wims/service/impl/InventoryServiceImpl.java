package com.wims.service.impl;

import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;
import com.wims.repository.InventoryRepository;
import com.wims.service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository inventoryRepository;

	public InventoryServiceImpl(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	@Transactional
	public Inventory addStock(Item item, Location bin, int qty) {

		Inventory inventory = inventoryRepository.findByItemAndBin(item, bin).orElseGet(() -> {
			Inventory inv = new Inventory();
			inv.setItem(item);
			inv.setBin(bin);
			return inv;
		});

		inventory.setQtyOnHand(inventory.getQtyOnHand() + qty);
		return inventoryRepository.save(inventory);
	}

	@Override
	@Transactional
	public void reserveStock(Inventory inventory, int qty) {

		if (inventory.getQtyOnHand() - inventory.getQtyReserved() < qty) {
			throw new RuntimeException("Insufficient stock");
		}

		inventory.setQtyReserved(inventory.getQtyReserved() + qty);
		inventoryRepository.save(inventory);
	}
}
