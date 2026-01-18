package com.wims.service.impl;

import com.wims.dto.request.CreateLocationRequest;
import com.wims.dto.response.LocationResponse;
import com.wims.entity.Location;
import com.wims.mapper.LocationMapper;
import com.wims.repository.LocationRepository;
import com.wims.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;
    private final LocationMapper mapper;

    public LocationServiceImpl(LocationRepository repository, LocationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public LocationResponse create(CreateLocationRequest request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    @Override
    public List<LocationResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public LocationResponse getById(Long id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Location not found"))
        );
    }

    @Override
    public List<LocationResponse> getByZone(String zone) {
        return repository.findByZone(zone).stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<LocationResponse> getByZoneAisle(String zone, String aisle) {
        return repository.findByZoneAndAisle(zone, aisle)
                .stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<LocationResponse> getByZoneAisleRack(String zone, String aisle, String rack) {
        return repository.findByZoneAndAisleAndRack(zone, aisle, rack)
                .stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<LocationResponse> getByFullPath(
            String zone, String aisle, String rack, String bin) {
        return repository.findByZoneAndAisleAndRackAndBin(zone, aisle, rack, bin)
                .stream().map(mapper::toResponse).toList();
    }

    @Override
    public LocationResponse update(Long id, CreateLocationRequest request) {
        Location location = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        mapper.updateEntity(location, request);
        return mapper.toResponse(repository.save(location));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
