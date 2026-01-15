package com.wims.repository;

import com.wims.entity.Inventory;
import com.wims.entity.Item;
import com.wims.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	Optional<Inventory> findByItemAndBin(Item item, Location bin);

	List<Inventory> findByItem(Item item);
}
