package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.wims.entity.Item;
import com.wims.entity.Location;
import com.wims.entity.StockMovement;
import com.wims.entity.User;
import com.wims.enums.StockMovementType;

class StockMovementServiceImplTest {

	 @Test
	    void stockmovement_basic_test() {

	        Item item = new Item();
	        item.setId(1L);

	        Location fromBin = new Location();
	        fromBin.setId(10L);

	        Location toBin = new Location();
	        toBin.setId(20L);

	        User user = new User();
	        user.setId(5L);

	        StockMovement sm = new StockMovement();
	        sm.setId(100L);
	        sm.setMovementType(StockMovementType.INBOUND);
	        sm.setItem(item);
	        sm.setFromBin(fromBin);
	        sm.setToBin(toBin);
	        sm.setQty(50);
	        sm.setPerformedBy(user);

	        assertNotNull(sm);
	        assertEquals(100L, sm.getId());
	        assertEquals(StockMovementType.INBOUND, sm.getMovementType());
	        assertEquals(50, sm.getQty());
	        assertNotNull(sm.getItem());
	        assertNotNull(sm.getPerformedBy());
	        assertNotNull(sm.getFromBin());
	        assertNotNull(sm.getToBin());
	        assertNotEquals(0, sm.getQty());
	    }

}
