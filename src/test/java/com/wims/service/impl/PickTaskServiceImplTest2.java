package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.wims.entity.Item;
import com.wims.entity.PickTask;
import com.wims.entity.SalesOrder;
import com.wims.entity.User;
import com.wims.enums.PickTaskStatus;

class PickTaskServiceImplTest2 {

	@Test
    void picktask_basic_test() {

        SalesOrder order = new SalesOrder();
        order.setId(1L);

        Item item = new Item();
        item.setId(2L);

        User user = new User();
        user.setId(3L);

        PickTask task = new PickTask();
        task.setId(10L);
        task.setSalesOrder(order);
        task.setItem(item);
        task.setAssignedTo(user);
        task.setQty(5);
        task.setStatus(PickTaskStatus.CREATED);

        assertNotNull(task);
        assertEquals(10L, task.getId());
        assertEquals(5, task.getQty());
        assertEquals(PickTaskStatus.CREATED, task.getStatus());
        assertNotNull(task.getSalesOrder());
        assertNotNull(task.getItem());
        assertNotNull(task.getAssignedTo());
        assertNotEquals(PickTaskStatus.COMPLETED, task.getStatus());
    }

}
