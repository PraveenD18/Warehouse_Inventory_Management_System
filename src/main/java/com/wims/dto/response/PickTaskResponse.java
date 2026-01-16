package com.wims.dto.response;

import com.wims.enums.PickTaskStatus;

public class PickTaskResponse {

	private Long id;
	private Long salesOrderId;
	private String itemName;
	private int quantity;
	private PickTaskStatus status;
	private String assignedTo;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public PickTaskStatus getStatus() {
		return status;
	}
	public void setStatus(PickTaskStatus status) {
		this.status = status;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	
}
