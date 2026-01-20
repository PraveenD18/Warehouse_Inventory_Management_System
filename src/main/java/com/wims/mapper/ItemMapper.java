package com.wims.mapper;

import com.wims.dto.request.ItemRequest;
import com.wims.dto.response.ItemResponse;
import com.wims.entity.Item;

public class ItemMapper {

    public static Item toEntity(ItemRequest request) {
        Item item = new Item();
        item.setSku(request.getSku());
        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setReorderLevel(request.getReorderLevel());
        return item;
    }

    public static ItemResponse toResponse(Item item) {
        ItemResponse response = new ItemResponse();
        response.setId(item.getId());
        response.setSku(item.getSku());
        response.setName(item.getName());
        response.setCategory(item.getCategory());
        response.setReorderLevel(item.getReorderLevel());
        return response;
    }
}
