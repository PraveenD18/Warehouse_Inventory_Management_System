package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;

class InventoryServiceImplTest2 {

	 @Test
	    void inventory_basic_test() 
	 {

	        Item item = new Item();
	        item.setId(1L);

	        Location bin = new Location();
	        bin.setId(100L);

	        Inventory inventory = new Inventory();
	        inventory.setId(10L);
	        inventory.setItem(item);
	        inventory.setBin(bin);
	        inventory.setQtyOnHand(50);
	        inventory.setQtyReserved(10);

	        assertNotNull(inventory);
	        assertEquals(10L, inventory.getId());
	        assertEquals(50, inventory.getQtyOnHand());
	        assertEquals(10, inventory.getQtyReserved());
	        assertNotNull(inventory.getItem());
	        assertNotNull(inventory.getBin());
	        assertEquals(1L, inventory.getItem().getId());
	        assertEquals(100L, inventory.getBin().getId());
	        assertNotEquals(0, inventory.getQtyOnHand());
	    }

}
