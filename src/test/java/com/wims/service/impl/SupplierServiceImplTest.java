package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.wims.entity.Supplier;

class SupplierServiceImplTest {

	@Test
    void supplier_basic_test() {

        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setName("ABC Suppliers");
        supplier.setContactPhone("9876543210");

        assertNotNull(supplier);
        assertEquals(1L, supplier.getId());
        assertEquals("ABC Suppliers", supplier.getName());
        assertEquals("9876543210", supplier.getContactPhone());
        assertNotEquals("XYZ Suppliers", supplier.getName());
    }

}
