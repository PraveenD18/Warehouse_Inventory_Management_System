package com.wims.mapper;

import com.wims.dto.response.*;
import com.wims.entity.*;

import java.util.stream.Collectors;

public class PurchaseOrderMapper {

    public static PurchaseOrderResponse toResponse(PurchaseOrder po) {

        PurchaseOrderResponse response = new PurchaseOrderResponse();
        response.setId(po.getId());
        response.setSupplierId(po.getSupplier().getId());
        response.setStatus(po.getStatus());
        response.setCreatedAt(po.getCreatedAt());
        response.setItems(
            po.getItems().stream()
                .map(PurchaseOrderMapper::mapItem)
                .collect(Collectors.toList())
        );

        return response;
    }

    private static PurchaseOrderItemResponse mapItem(PurchaseOrderItem item) {

        PurchaseOrderItemResponse res = new PurchaseOrderItemResponse();
        res.setItemId(item.getItem().getId());
        res.setOrderedQty(item.getOrderedQty());
        res.setReceivedQty(item.getReceivedQty());
        return res;
    }
}
