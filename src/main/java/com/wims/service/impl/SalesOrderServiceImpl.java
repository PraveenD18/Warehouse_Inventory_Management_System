package com.wims.service.impl;

import com.wims.entity.SalesOrder;
import com.wims.enums.OrderStatus;
import com.wims.repository.SalesOrderRepository;
import com.wims.service.SalesOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	private final SalesOrderRepository salesOrderRepository;

	public SalesOrderServiceImpl(SalesOrderRepository salesOrderRepository) {
		this.salesOrderRepository = salesOrderRepository;
	}

	@Override
	public SalesOrder createSalesOrder(SalesOrder order) {
		order.setStatus(OrderStatus.PENDING);
		return salesOrderRepository.save(order);
	}

	@Override
	public List<SalesOrder> getOrdersByStatus(OrderStatus status) {
		return salesOrderRepository.findByStatus(status);
	}
}
