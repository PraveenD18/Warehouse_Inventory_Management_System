package com.wims.repository;

import com.wims.entity.PickTask;
import com.wims.entity.User;
import com.wims.enums.PickTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickTaskRepository extends JpaRepository<PickTask, Long> {

	List<PickTask> findByAssignedTo(User user);

	List<PickTask> findByStatus(PickTaskStatus status);
}
