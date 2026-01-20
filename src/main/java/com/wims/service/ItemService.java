package com.wims.service;

import com.wims.dto.request.ItemRequest;
import com.wims.dto.response.ItemResponse;

import java.util.List;

public interface ItemService {

    ItemResponse createItem(ItemRequest request);
    List<ItemResponse> getAllItems();
    ItemResponse getItemById(Long id);
    ItemResponse updateItem(Long id, ItemRequest request);
    void deleteItem(Long id);
}
