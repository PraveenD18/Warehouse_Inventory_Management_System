package com.wims.controller;

import com.wims.dto.request.CreateSalesOrderRequest;
import com.wims.dto.response.SalesOrderResponse;
import com.wims.entity.SalesOrder;
import com.wims.service.SalesOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

	private final SalesOrderService salesOrderService;

	public SalesOrderController(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SalesOrderResponse createOrder(@Valid @RequestBody CreateSalesOrderRequest request) {

		SalesOrder order = new SalesOrder();
		SalesOrder saved = salesOrderService.createSalesOrder(order);
		SalesOrderResponse res = new SalesOrderResponse();
		res.setOrderId(saved.getId());
		res.setStatus(saved.getStatus());
		res.setCreatedAt(saved.getCreatedAt());
		return res;
	}
}
