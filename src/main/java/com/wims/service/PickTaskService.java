package com.wims.service;

import java.util.List;

import com.wims.dto.request.AssignPickTaskRequest;
import com.wims.dto.response.PickTaskResponse;

public interface PickTaskService {

    PickTaskResponse createPickTask(AssignPickTaskRequest request);
    List<PickTaskResponse> getAllPickTasks();
    PickTaskResponse getPickTaskById(Long id);
    List<PickTaskResponse> getPickTasksByUser(Long userId);
    PickTaskResponse updatePickTask(Long id, AssignPickTaskRequest request);
    void deletePickTask(Long id);
}
