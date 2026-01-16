package com.wims.service;

import com.wims.entity.SalesOrder;
import com.wims.enums.OrderStatus;
import com.wims.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {

	private final SalesOrderRepository salesOrderRepository;

	public SalesOrderService(SalesOrderRepository salesOrderRepository) {
		this.salesOrderRepository = salesOrderRepository;
	}

	public SalesOrder createSalesOrder(SalesOrder order) {
		order.setStatus(OrderStatus.PENDING);
		return salesOrderRepository.save(order);
	}

	public List<SalesOrder> getOrdersByStatus(OrderStatus status) {
		return salesOrderRepository.findByStatus(status);
	}
}
