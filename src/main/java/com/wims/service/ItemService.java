package com.wims.service;

import com.wims.entity.Item;

import java.util.List;

public interface ItemService {

	Item createItem(Item item);

	Item getItemById(Long id);

	List<Item> getAllItems();
}
