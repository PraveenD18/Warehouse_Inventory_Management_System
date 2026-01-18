package com.wims.service;

import com.wims.dto.request.CreateLocationRequest;
import com.wims.dto.response.LocationResponse;

import java.util.List;

public interface LocationService {

    LocationResponse create(CreateLocationRequest request);

    List<LocationResponse> getAll();

    LocationResponse getById(Long id);

    List<LocationResponse> getByZone(String zone);

    List<LocationResponse> getByZoneAisle(String zone, String aisle);

    List<LocationResponse> getByZoneAisleRack(String zone, String aisle, String rack);

    List<LocationResponse> getByFullPath(String zone, String aisle, String rack, String bin);

    LocationResponse update(Long id, CreateLocationRequest request);

    void delete(Long id);
}
