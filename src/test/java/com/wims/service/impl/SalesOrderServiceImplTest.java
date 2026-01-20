package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wims.entity.Customer;
import com.wims.entity.Item;
import com.wims.entity.SalesOrder;
import com.wims.entity.SalesOrderItem;
import com.wims.enums.OrderStatus;

class SalesOrderServiceImplTest {

	@Test
    void salesorder_basic_test() {

        Customer customer = new Customer();
        customer.setId(1L);

        Item item = new Item();
        item.setId(10L);

        SalesOrderItem soi = new SalesOrderItem();
        soi.setItem(item);
        soi.setOrderedQty(5);
        soi.setAllocatedQty(0);

        List<SalesOrderItem> items = new ArrayList<>();
        items.add(soi);

        SalesOrder order = new SalesOrder();
        order.setId(100L);
        order.setCustomer(customer);
        order.setStatus(OrderStatus.CREATED);
        order.setItems(items);

        assertNotNull(order);
        assertEquals(100L, order.getId());
        assertEquals(OrderStatus.CREATED, order.getStatus());
        assertNotNull(order.getCustomer());
        assertEquals(1L, order.getCustomer().getId());
        assertEquals(1, order.getItems().size());
        assertNotEquals(OrderStatus.SHIPPED, order.getStatus());
    }

}
