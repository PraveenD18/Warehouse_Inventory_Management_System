package com.wims.dto.response;

import com.wims.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class SalesOrderResponse {

	private Long orderId;
	private OrderStatus status;
	private LocalDateTime createdAt;

	private List<SalesOrderItemResponse> items;

	// getters & setters

	public static class SalesOrderItemResponse {
		private Long itemId;
		private String itemName;
		private int orderedQty;

		// getters & setters
	}
}
