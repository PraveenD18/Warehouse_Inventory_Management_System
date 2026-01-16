package com.wims.service;

import com.wims.entity.PurchaseOrder;
import com.wims.enums.PurchaseOrderStatus;

import java.util.List;

public interface PurchaseOrderService {

	PurchaseOrder createPurchaseOrder(PurchaseOrder po);

	List<PurchaseOrder> getByStatus(PurchaseOrderStatus status);
}
