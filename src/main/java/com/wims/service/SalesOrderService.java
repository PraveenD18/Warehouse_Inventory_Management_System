package com.wims.service;

import com.wims.entity.SalesOrder;
import com.wims.enums.OrderStatus;

import java.util.List;

public interface SalesOrderService {

	SalesOrder createSalesOrder(SalesOrder order);

	List<SalesOrder> getOrdersByStatus(OrderStatus status);
}
