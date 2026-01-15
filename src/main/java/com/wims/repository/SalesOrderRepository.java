package com.wims.repository;

import com.wims.entity.SalesOrder;
import com.wims.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

	List<SalesOrder> findByStatus(OrderStatus status);
}
