package com.wims.dto.response;

import com.wims.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class SalesOrderResponse {

	private Long orderId;
	private OrderStatus status;
	private LocalDateTime createdAt;

	private List<SalesOrderItemResponse> items;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<SalesOrderItemResponse> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItemResponse> items) {
		this.items = items;
	}

	public static class SalesOrderItemResponse {
		private Long itemId;
		private String itemName;

		public Long getItemId() {
			return itemId;
		}

		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public int getOrderedQty() {
			return orderedQty;
		}

		public void setOrderedQty(int orderedQty) {
			this.orderedQty = orderedQty;
		}

		private int orderedQty;

	}
}
