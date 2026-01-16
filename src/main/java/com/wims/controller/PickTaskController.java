package com.wims.controller;

import com.wims.dto.request.AssignPickTaskRequest;
import com.wims.dto.response.PickTaskResponse;
import com.wims.entity.PickTask;
import com.wims.service.PickTaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pick-tasks")
public class PickTaskController {

	private final PickTaskService pickTaskService;

	public PickTaskController(PickTaskService pickTaskService) {
		this.pickTaskService = pickTaskService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PickTaskResponse assignPickTask(@Valid @RequestBody AssignPickTaskRequest request) {

		PickTask task = new PickTask();
		PickTask saved = pickTaskService.createPickTask(task);

		PickTaskResponse res = new PickTaskResponse();
		res.setId(saved.getId());
		res.setQuantity(saved.getQty());
		res.setStatus(saved.getStatus());
		return res;
	}
}
