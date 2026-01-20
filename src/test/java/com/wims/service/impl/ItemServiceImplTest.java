package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.wims.entity.Item;

class ItemServiceImplTest {

    @Test
    void item_basic_test() {

        Item item = new Item();
        item.setId(1L);
        item.setSku("SKU001");
        item.setName("Laptop");
        item.setCategory("Electronics");
        item.setReorderLevel(10);

        assertNotNull(item);
        assertEquals(1L, item.getId());
        assertEquals("SKU001", item.getSku());
        assertEquals("Laptop", item.getName());
        assertEquals("Electronics", item.getCategory());
        assertEquals(10, item.getReorderLevel());
        assertNotEquals(0, item.getReorderLevel());
    }
}
