package com.wims.service;

import com.wims.entity.StockMovement;
import com.wims.enums.StockMovementType;
import com.wims.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementService {

	private final StockMovementRepository stockMovementRepository;

	public StockMovementService(StockMovementRepository stockMovementRepository) {
		this.stockMovementRepository = stockMovementRepository;
	}

	public StockMovement logMovement(StockMovement movement) {
		return stockMovementRepository.save(movement);
	}

	public List<StockMovement> getByType(StockMovementType type) {
		return stockMovementRepository.findByMovementType(type);
	}
}
