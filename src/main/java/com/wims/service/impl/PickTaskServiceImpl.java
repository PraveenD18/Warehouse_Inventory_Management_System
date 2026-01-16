package com.wims.service.impl;

import com.wims.entity.PickTask;
import com.wims.enums.PickTaskStatus;
import com.wims.repository.PickTaskRepository;
import com.wims.service.PickTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickTaskServiceImpl implements PickTaskService {

	private final PickTaskRepository pickTaskRepository;

	public PickTaskServiceImpl(PickTaskRepository pickTaskRepository) {
		this.pickTaskRepository = pickTaskRepository;
	}

	@Override
	public PickTask createPickTask(PickTask task) {
		task.setStatus(PickTaskStatus.CREATED);
		return pickTaskRepository.save(task);
	}

	@Override
	public List<PickTask> getByStatus(PickTaskStatus status) {
		return pickTaskRepository.findByStatus(status);
	}
}
