package com.wims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.wims.entity.PurchaseOrder;
import com.wims.entity.PurchaseOrderItem;
import com.wims.entity.Supplier;
import com.wims.enums.PurchaseOrderStatus;

class PurchaseOrderServiceImplTest {

	@Test
    void purchaseorder_basic_test() {

        Supplier supplier = new Supplier();
        supplier.setId(1L);

        PurchaseOrderItem item = new PurchaseOrderItem();
        item.setOrderedQty(10);
        item.setReceivedQty(0);

        List<PurchaseOrderItem> items = new ArrayList<>();
        items.add(item);

        PurchaseOrder po = new PurchaseOrder();
        po.setId(100L);
        po.setSupplier(supplier);
        po.setStatus(PurchaseOrderStatus.CREATED);
        po.setItems(items);

        assertNotNull(po);
        assertEquals(100L, po.getId());
        assertEquals(PurchaseOrderStatus.CREATED, po.getStatus());
        assertNotNull(po.getSupplier());
        assertEquals(1L, po.getSupplier().getId());
        assertEquals(1, po.getItems().size());
        assertNotEquals(PurchaseOrderStatus.COMPLETED, po.getStatus());
    }

}
