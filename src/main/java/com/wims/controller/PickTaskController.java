package com.wims.controller;

import com.wims.dto.request.AssignPickTaskRequest;
import com.wims.dto.response.PickTaskResponse;
import com.wims.service.PickTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pick-tasks")
public class PickTaskController {

    private final PickTaskService pickTaskService;

    public PickTaskController(PickTaskService pickTaskService) {
        this.pickTaskService = pickTaskService;
    }

    @PostMapping
    public ResponseEntity<PickTaskResponse> create(
            @RequestBody AssignPickTaskRequest request) {
        return ResponseEntity.ok(pickTaskService.createPickTask(request));
    }

    @GetMapping
    public ResponseEntity<List<PickTaskResponse>> getAll() {
        return ResponseEntity.ok(pickTaskService.getAllPickTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PickTaskResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pickTaskService.getPickTaskById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PickTaskResponse>> getByUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(pickTaskService.getPickTasksByUser(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PickTaskResponse> update(
            @PathVariable Long id,
            @RequestBody AssignPickTaskRequest request) {
        return ResponseEntity.ok(pickTaskService.updatePickTask(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pickTaskService.deletePickTask(id);
        return ResponseEntity.noContent().build();
    }
}
