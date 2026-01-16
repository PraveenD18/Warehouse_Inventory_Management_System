package com.wims.service;

import com.wims.entity.Item;
import com.wims.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Item createItem(Item item) {
		if (itemRepository.existsBySku(item.getSku())) {
			throw new RuntimeException("Item SKU already exists");
		}
		return itemRepository.save(item);
	}

	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
	}

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
