package com.wims.controller;

import com.wims.dto.request.ItemRequest;
import com.wims.dto.response.ItemResponse;
import com.wims.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request) {
		return ResponseEntity.ok(itemService.createItem(request));
	}

	@GetMapping
	public ResponseEntity<List<ItemResponse>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemResponse> getItemById(@PathVariable Long id) {
		return ResponseEntity.ok(itemService.getItemById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id, @RequestBody ItemRequest request) {
		return ResponseEntity.ok(itemService.updateItem(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}
}
