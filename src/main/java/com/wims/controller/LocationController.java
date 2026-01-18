package com.wims.controller;

import com.wims.dto.request.CreateLocationRequest;
import com.wims.dto.response.LocationResponse;
import com.wims.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    // ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LocationResponse> create(@RequestBody CreateLocationRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    // ADMIN + MANAGER
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/zone/{zone}")
    public ResponseEntity<List<LocationResponse>> byZone(@PathVariable String zone) {
        return ResponseEntity.ok(service.getByZone(zone));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/zone/{zone}/aisle/{aisle}")
    public ResponseEntity<List<LocationResponse>> byZoneAisle(
            @PathVariable String zone,
            @PathVariable String aisle) {
        return ResponseEntity.ok(service.getByZoneAisle(zone, aisle));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/zone/{zone}/aisle/{aisle}/rack/{rack}")
    public ResponseEntity<List<LocationResponse>> byZoneAisleRack(
            @PathVariable String zone,
            @PathVariable String aisle,
            @PathVariable String rack) {
        return ResponseEntity.ok(service.getByZoneAisleRack(zone, aisle, rack));
    }

    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping("/zone/{zone}/aisle/{aisle}/rack/{rack}/bin/{bin}")
    public ResponseEntity<List<LocationResponse>> byFullPath(
            @PathVariable String zone,
            @PathVariable String aisle,
            @PathVariable String rack,
            @PathVariable String bin) {
        return ResponseEntity.ok(service.getByFullPath(zone, aisle, rack, bin));
    }

    // ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LocationResponse> update(
            @PathVariable Long id,
            @RequestBody CreateLocationRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    // ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
