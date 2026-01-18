package com.wims.mapper;

import com.wims.dto.request.CreateLocationRequest;
import com.wims.dto.response.LocationResponse;
import com.wims.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {

    public Location toEntity(CreateLocationRequest request) {
        Location location = new Location();
        location.setZone(request.getZone());
        location.setAisle(request.getAisle());
        location.setRack(request.getRack());
        location.setBin(request.getBin());
        location.setBinType(request.getBinType());
        return location;
    }

    public void updateEntity(Location location, CreateLocationRequest request) {
        location.setZone(request.getZone());
        location.setAisle(request.getAisle());
        location.setRack(request.getRack());
        location.setBin(request.getBin());
        location.setBinType(request.getBinType());
    }

    public LocationResponse toResponse(Location location) {
        LocationResponse response = new LocationResponse();
        response.setId(location.getId());
        response.setZone(location.getZone());
        response.setAisle(location.getAisle());
        response.setRack(location.getRack());
        response.setBin(location.getBin());
        response.setBinType(location.getBinType());
        return response;
    }
}
