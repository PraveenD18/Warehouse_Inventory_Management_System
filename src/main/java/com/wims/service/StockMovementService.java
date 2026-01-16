package com.wims.service;

import com.wims.entity.StockMovement;
import com.wims.enums.StockMovementType;

import java.util.List;

public interface StockMovementService {

	StockMovement logMovement(StockMovement movement);

	List<StockMovement> getByType(StockMovementType type);
}
