package com.wims.service;

import com.wims.entity.PickTask;
import com.wims.enums.PickTaskStatus;

import java.util.List;

public interface PickTaskService {

    PickTask createPickTask(PickTask task);

    List<PickTask> getByStatus(PickTaskStatus status);
}
