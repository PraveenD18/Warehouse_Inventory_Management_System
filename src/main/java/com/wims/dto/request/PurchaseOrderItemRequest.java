package com.wims.dto.request;

public class PurchaseOrderItemRequest {

    private Long itemId;
    private int orderedQty;

    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public int getOrderedQty() {
        return orderedQty;
    }
    public void setOrderedQty(int orderedQty) {
        this.orderedQty = orderedQty;
    }
}
