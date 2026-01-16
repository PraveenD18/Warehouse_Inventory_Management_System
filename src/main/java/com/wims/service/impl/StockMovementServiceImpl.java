package com.wims.service.impl;

import com.wims.entity.StockMovement;
import com.wims.enums.StockMovementType;
import com.wims.repository.StockMovementRepository;
import com.wims.service.StockMovementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementServiceImpl implements StockMovementService {

	private final StockMovementRepository stockMovementRepository;

	public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
		this.stockMovementRepository = stockMovementRepository;
	}

	@Override
	public StockMovement logMovement(StockMovement movement) {
		return stockMovementRepository.save(movement);
	}

	@Override
	public List<StockMovement> getByType(StockMovementType type) {
		return stockMovementRepository.findByMovementType(type);
	}
}
