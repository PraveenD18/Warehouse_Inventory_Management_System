package com.wims.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wims.dto.request.AssignPickTaskRequest;
import com.wims.dto.response.PickTaskResponse;
import com.wims.entity.PickTask;
import com.wims.entity.User;
import com.wims.mapper.PickTaskMapper;
import com.wims.repository.ItemRepository;
import com.wims.repository.PickTaskRepository;
import com.wims.repository.SalesOrderRepository;
import com.wims.repository.UserRepository;
import com.wims.service.PickTaskService;

@Service
public class PickTaskServiceImpl implements PickTaskService {

    private final PickTaskRepository pickTaskRepository;
    private final SalesOrderRepository salesOrderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public PickTaskServiceImpl(
            PickTaskRepository pickTaskRepository,
            SalesOrderRepository salesOrderRepository,
            ItemRepository itemRepository,
            UserRepository userRepository) {

        this.pickTaskRepository = pickTaskRepository;
        this.salesOrderRepository = salesOrderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PickTaskResponse createPickTask(AssignPickTaskRequest request) {

        PickTask task = new PickTask();
        task.setSalesOrder(
                salesOrderRepository.findById(request.getSalesOrderId())
                        .orElseThrow(() -> new RuntimeException("SalesOrder not found"))
        );
        task.setItem(
                itemRepository.findById(request.getItemId())
                        .orElseThrow(() -> new RuntimeException("Item not found"))
        );

        if (request.getAssignedToUserId() != null) {
            User user = userRepository.findById(request.getAssignedToUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            task.setAssignedTo(user);
        }

        task.setQty(request.getQty());
        task.setStatus(request.getStatus());

        return PickTaskMapper.toResponse(pickTaskRepository.save(task));
    }

    @Override
    public List<PickTaskResponse> getAllPickTasks() {
        return pickTaskRepository.findAll()
                .stream()
                .map(PickTaskMapper::toResponse)
                .toList();
    }

    @Override
    public PickTaskResponse getPickTaskById(Long id) {
        PickTask task = pickTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PickTask not found"));
        return PickTaskMapper.toResponse(task);
    }

    @Override
    public List<PickTaskResponse> getPickTasksByUser(Long userId) {
        return pickTaskRepository.findByAssignedTo_Id(userId)
                .stream()
                .map(PickTaskMapper::toResponse)
                .toList();
    }

    @Override
    public PickTaskResponse updatePickTask(Long id, AssignPickTaskRequest request) {
        PickTask task = pickTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PickTask not found"));

        task.setQty(request.getQty());
        task.setStatus(request.getStatus());

        return PickTaskMapper.toResponse(pickTaskRepository.save(task));
    }

    @Override
    public void deletePickTask(Long id) {
        pickTaskRepository.deleteById(id);
    }
}
