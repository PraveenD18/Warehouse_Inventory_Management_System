package com.wims.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class CreateSalesOrderRequest {

	@NotNull(message = "Customer ID is required")
	private Long customerId;

	@NotEmpty(message = "Order must contain at least one item")
	private List<SalesOrderItemRequest> items;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<SalesOrderItemRequest> getItems() {
		return items;
	}

	public void setItems(List<SalesOrderItemRequest> items) {
		this.items = items;
	}

	public static class SalesOrderItemRequest {

		@NotNull
		private Long itemId;

		@Positive(message = "Quantity must be greater than zero")
		private int quantity;

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

	}
}
