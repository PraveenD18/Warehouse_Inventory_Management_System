package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wims.entity.Location;
import com.wims.enums.BinType;

class LocationServiceImplTest2 {

	 @Test
	    void location_basic_test() {

	        Location location = new Location();
	        location.setId(1L);
	        location.setZone("Z1");
	        location.setAisle("A1");
	        location.setRack("R1");
	        location.setBin("B1");
	        location.setBinType(BinType.STANDARD);

	        assertNotNull(location);
	        assertEquals(1L, location.getId());
	        assertEquals("Z1", location.getZone());
	        assertEquals("A1", location.getAisle());
	        assertEquals("R1", location.getRack());
	        assertEquals("B1", location.getBin());
	        assertEquals(BinType.STANDARD, location.getBinType());
	        assertNotEquals(BinType.HEAVY_DUTY, location.getBinType());
	    }
}
