package com.wims.dto.request;

import java.util.List;

public class CreatePurchaseOrderRequest {

    private Long supplierId;
    private List<PurchaseOrderItemRequest> items;

    public Long getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    public List<PurchaseOrderItemRequest> getItems() {
        return items;
    }
    public void setItems(List<PurchaseOrderItemRequest> items) {
        this.items = items;
    }
}
