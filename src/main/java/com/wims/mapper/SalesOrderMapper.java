package com.wims.mapper;

import com.wims.dto.response.*;
import com.wims.entity.*;

import java.util.stream.Collectors;

public class SalesOrderMapper {

    public static SalesOrderResponse toResponse(SalesOrder order) {
        SalesOrderResponse res = new SalesOrderResponse();
        res.setId(order.getId());
        res.setStatus(order.getStatus().name());
        res.setCreatedAt(order.getCreatedAt());

        res.setCustomerName(
            order.getCustomer().getName() != null
                ? order.getCustomer().getName()
                : "UNKNOWN"
        );

        if (order.getItems() != null) {
            res.setItems(
                order.getItems().stream()
                    .map(SalesOrderMapper::toItemResponse)
                    .collect(Collectors.toList())
            );
        }

        return res;
    }

    private static SalesOrderItemResponse toItemResponse(SalesOrderItem item) {
        SalesOrderItemResponse r = new SalesOrderItemResponse();
        r.setItemId(item.getItem().getId());
        r.setOrderedQty(item.getOrderedQty());
        r.setAllocatedQty(item.getAllocatedQty());

        r.setItemName(
            item.getItem().getName() != null
                ? item.getItem().getName()
                : "UNKNOWN"
        );

        return r;
    }
}
