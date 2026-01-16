package com.wims.service.impl;

import com.wims.entity.PurchaseOrder;
import com.wims.enums.PurchaseOrderStatus;
import com.wims.repository.PurchaseOrderRepository;
import com.wims.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	private final PurchaseOrderRepository purchaseOrderRepository;

	public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
	}

	@Override
	public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
		po.setStatus(PurchaseOrderStatus.CREATED);
		return purchaseOrderRepository.save(po);
	}

	@Override
	public List<PurchaseOrder> getByStatus(PurchaseOrderStatus status) {
		return purchaseOrderRepository.findByStatus(status);
	}
}
