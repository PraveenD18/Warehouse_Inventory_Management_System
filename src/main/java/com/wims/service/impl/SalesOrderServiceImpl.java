package com.wims.service.impl;

import com.wims.dto.request.CreateSalesOrderRequest;
import com.wims.dto.request.SalesOrderItemRequest;
import com.wims.dto.response.SalesOrderResponse;
import com.wims.entity.*;
import com.wims.enums.OrderStatus;
import com.wims.mapper.SalesOrderMapper;
import com.wims.repository.*;
import com.wims.service.SalesOrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SalesOrderServiceImpl implements SalesOrderService {

    private final SalesOrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ItemRepository itemRepo;

    public SalesOrderServiceImpl(
            SalesOrderRepository orderRepo,
            CustomerRepository customerRepo,
            ItemRepository itemRepo
    ) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public SalesOrderResponse create(CreateSalesOrderRequest request) {

        Customer customer = customerRepo.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        SalesOrder order = new SalesOrder();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.CREATED);

        List<SalesOrderItem> items = new ArrayList<>();

        for (SalesOrderItemRequest req : request.getItems()) {
            Item item = itemRepo.findById(req.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

            SalesOrderItem soi = new SalesOrderItem();
            soi.setSalesOrder(order);
            soi.setItem(item);
            soi.setOrderedQty(req.getOrderedQty());
            soi.setAllocatedQty(0);

            items.add(soi);
        }

        order.setItems(items);

        SalesOrder savedOrder = orderRepo.save(order);
        return SalesOrderMapper.toResponse(savedOrder);
    }

    @Override
    public List<SalesOrderResponse> getAll() {
        return orderRepo.findAll()
            .stream()
            .map(SalesOrderMapper::toResponse)
            .toList();
    }
}
