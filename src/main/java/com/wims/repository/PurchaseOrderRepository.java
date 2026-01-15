package com.wims.repository;

import com.wims.entity.PurchaseOrder;
import com.wims.enums.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

	List<PurchaseOrder> findByStatus(PurchaseOrderStatus status);
}
