package com.wims.service.impl;

import com.wims.dto.request.*;
import com.wims.dto.response.*;
import com.wims.entity.*;
import com.wims.enums.PurchaseOrderStatus;
import com.wims.mapper.PurchaseOrderMapper;
import com.wims.repository.*;
import com.wims.service.PurchaseOrderService;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;
    private final ItemRepository itemRepo;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepo,
            SupplierRepository supplierRepo,
            ItemRepository itemRepo) {

        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public PurchaseOrderResponse createPurchaseOrder(CreatePurchaseOrderRequest request) {

        PurchaseOrder po = new PurchaseOrder();
        po.setSupplier(
            supplierRepo.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"))
        );
        po.setStatus(PurchaseOrderStatus.CREATED);

        po.setItems(
            request.getItems().stream().map(reqItem -> {

                PurchaseOrderItem poi = new PurchaseOrderItem();
                poi.setPurchaseOrder(po);

                poi.setItem(
                    itemRepo.findById(reqItem.getItemId())
                        .orElseThrow(() -> new RuntimeException("Item not found"))
                );

                poi.setOrderedQty(reqItem.getOrderedQty());
                poi.setReceivedQty(0);

                return poi;

            }).collect(Collectors.toList())
        );

        return PurchaseOrderMapper.toResponse(poRepo.save(po));
    }

    @Override
    public List<PurchaseOrderResponse> getAllPurchaseOrders() {
        return poRepo.findAll()
                .stream()
                .map(PurchaseOrderMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderResponse getPurchaseOrderById(Long id) {
        return poRepo.findById(id)
                .map(PurchaseOrderMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("PO not found"));
    }
}
