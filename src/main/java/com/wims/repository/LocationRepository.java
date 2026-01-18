package com.wims.repository;

import com.wims.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByZone(String zone);

    List<Location> findByZoneAndAisle(String zone, String aisle);

    List<Location> findByZoneAndAisleAndRack(String zone, String aisle, String rack);

    List<Location> findByZoneAndAisleAndRackAndBin(
            String zone, String aisle, String rack, String bin
    );
}
