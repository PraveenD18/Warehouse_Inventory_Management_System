package com.wims.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.wims.enums.PurchaseOrderStatus;

public class PurchaseOrderResponse {

    private Long id;
    private Long supplierId;
    private PurchaseOrderStatus status;
    private LocalDateTime createdAt;
    private List<PurchaseOrderItemResponse> items;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    public PurchaseOrderStatus getStatus() {
        return status;
    }
    public void setStatus(PurchaseOrderStatus status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public List<PurchaseOrderItemResponse> getItems() {
        return items;
    }
    public void setItems(List<PurchaseOrderItemResponse> items) {
        this.items = items;
    }
}
