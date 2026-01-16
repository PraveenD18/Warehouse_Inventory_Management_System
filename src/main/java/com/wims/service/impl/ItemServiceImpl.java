package com.wims.service.impl;

import com.wims.entity.Item;
import com.wims.repository.ItemRepository;
import com.wims.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item createItem(Item item) {
		if (itemRepository.existsBySku(item.getSku())) {
			throw new RuntimeException("Item SKU already exists");
		}
		return itemRepository.save(item);
	}

	@Override
	public Item getItemById(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
}
