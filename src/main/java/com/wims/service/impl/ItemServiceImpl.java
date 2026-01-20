package com.wims.service.impl;

import com.wims.dto.request.ItemRequest;
import com.wims.dto.response.ItemResponse;
import com.wims.entity.Item;
import com.wims.mapper.ItemMapper;
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
    public ItemResponse createItem(ItemRequest request) {
        Item item = ItemMapper.toEntity(request);
        return ItemMapper.toResponse(itemRepository.save(item));
    }

    @Override
    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemMapper::toResponse)
                .toList();
    }

    @Override
    public ItemResponse getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return ItemMapper.toResponse(item);
    }

    @Override
    public ItemResponse updateItem(Long id, ItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        item.setSku(request.getSku());
        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setReorderLevel(request.getReorderLevel());

        return ItemMapper.toResponse(itemRepository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
