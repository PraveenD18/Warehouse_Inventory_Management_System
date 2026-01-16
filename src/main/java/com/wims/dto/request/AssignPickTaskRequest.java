package com.wims.dto.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AssignPickTaskRequest {

    @NotNull(message = "Sales order ID is required")
    private Long salesOrderId;

    @NotNull(message = "Item ID is required")
    private Long itemId;

    @Positive(message = "Pick quantity must be greater than zero")
    private int quantity;

    @NotNull(message = "User ID is required")
    private Long assignedToUserId;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getAssignedToUserId() {
		return assignedToUserId;
	}

	public void setAssignedToUserId(Long assignedToUserId) {
		this.assignedToUserId = assignedToUserId;
	}

    
}

