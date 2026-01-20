package com.wims.service.impl;

import com.wims.dto.request.CreateStockMovementRequest;
import com.wims.dto.response.StockMovementResponse;
import com.wims.entity.*;
import com.wims.mapper.StockMovementMapper;
import com.wims.repository.*;
import com.wims.service.StockMovementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementServiceImpl implements StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    private final ItemRepository itemRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public StockMovementServiceImpl(
            StockMovementRepository stockMovementRepository,
            ItemRepository itemRepository,
            LocationRepository locationRepository,
            UserRepository userRepository
    ) {
        this.stockMovementRepository = stockMovementRepository;
        this.itemRepository = itemRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public StockMovementResponse create(CreateStockMovementRequest request) {

        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        User user = userRepository.findById(request.getPerformedByUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Location fromBin = request.getFromBinId() != null
                ? locationRepository.findById(request.getFromBinId())
                    .orElseThrow(() -> new RuntimeException("From location not found"))
                : null;

        Location toBin = request.getToBinId() != null
                ? locationRepository.findById(request.getToBinId())
                    .orElseThrow(() -> new RuntimeException("To location not found"))
                : null;

        StockMovement sm = new StockMovement();
        sm.setMovementType(request.getMovementType());
        sm.setItem(item);
        sm.setFromBin(fromBin);
        sm.setToBin(toBin);
        sm.setQty(request.getQty());
        sm.setPerformedBy(user);

        return StockMovementMapper.toResponse(
                stockMovementRepository.save(sm)
        );
    }

    @Override
    public List<StockMovementResponse> getAll() {
        return stockMovementRepository.findAll()
                .stream()
                .map(StockMovementMapper::toResponse)
                .toList();
    }
}
