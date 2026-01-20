package com.wims.dto.response;

import com.wims.enums.PickTaskStatus;

public class PickTaskResponse {

    private Long id;
    private Long salesOrderId;
    private Long itemId;
    private int qty;
    private Long assignedToUserId;
    private PickTaskStatus status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSalesOrderId() {
        return salesOrderId;
    }
    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public Long getAssignedToUserId() {
        return assignedToUserId;
    }
    public void setAssignedToUserId(Long assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }
    public PickTaskStatus getStatus() {
        return status;
    }
    public void setStatus(PickTaskStatus status) {
        this.status = status;
    }
}
