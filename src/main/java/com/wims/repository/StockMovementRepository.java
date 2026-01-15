package com.wims.repository;

import com.wims.entity.StockMovement;
import com.wims.enums.StockMovementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

	List<StockMovement> findByMovementType(StockMovementType movementType);
}
