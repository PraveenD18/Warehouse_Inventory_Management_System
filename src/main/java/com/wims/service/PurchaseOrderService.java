package com.wims.service;

import com.wims.entity.PurchaseOrder;
import com.wims.enums.PurchaseOrderStatus;
import com.wims.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderService {

	private final PurchaseOrderRepository purchaseOrderRepository;

	public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
	}

	public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
		po.setStatus(PurchaseOrderStatus.CREATED);
		return purchaseOrderRepository.save(po);
	}

	public List<PurchaseOrder> getByStatus(PurchaseOrderStatus status) {
		return purchaseOrderRepository.findByStatus(status);
	}
}
