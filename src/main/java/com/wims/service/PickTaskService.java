package com.wims.service;

import com.wims.entity.PickTask;
import com.wims.enums.PickTaskStatus;
import com.wims.repository.PickTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickTaskService {

    private final PickTaskRepository pickTaskRepository;

    public PickTaskService(PickTaskRepository pickTaskRepository) {
        this.pickTaskRepository = pickTaskRepository;
    }

    public PickTask createPickTask(PickTask task) {
        task.setStatus(PickTaskStatus.CREATED);
        return pickTaskRepository.save(task);
    }

    public List<PickTask> getByStatus(PickTaskStatus status) {
        return pickTaskRepository.findByStatus(status);
    }
}
