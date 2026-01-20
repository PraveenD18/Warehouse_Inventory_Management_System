package com.wims.mapper;

import com.wims.dto.response.PickTaskResponse;
import com.wims.entity.PickTask;

public class PickTaskMapper {

    public static PickTaskResponse toResponse(PickTask task) {
        PickTaskResponse response = new PickTaskResponse();
        response.setId(task.getId());
        response.setSalesOrderId(task.getSalesOrder().getId());
        response.setItemId(task.getItem().getId());
        response.setQty(task.getQty());
        response.setAssignedToUserId(
                task.getAssignedTo() != null ? task.getAssignedTo().getId() : null
        );
        response.setStatus(task.getStatus());
        return response;
    }
}
