package com.wims.dto.response;

public class PurchaseOrderItemResponse {

    private Long itemId;
    private int orderedQty;
    private int receivedQty;

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
    public int getReceivedQty() {
        return receivedQty;
    }
    public void setReceivedQty(int receivedQty) {
        this.receivedQty = receivedQty;
    }
}
