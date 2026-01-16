package com.wims.controller;

import com.wims.dto.request.CreateItemRequest;
import com.wims.dto.response.ItemResponse;
import com.wims.entity.Item;
import com.wims.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse createItem(
            @Valid @RequestBody CreateItemRequest request) {

        Item item = new Item();
        item.setSku(request.getSku());
        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setReorderLevel(request.getReorderLevel());

        Item saved = itemService.createItem(item);
        return mapToResponse(saved);
    }

    @GetMapping
    public List<ItemResponse> getAllItems() {
        return itemService.getAllItems()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ItemResponse mapToResponse(Item item) {
        ItemResponse res = new ItemResponse();
        res.setId(item.getId());
        res.setSku(item.getSku());
        res.setName(item.getName());
        res.setCategory(item.getCategory());
        res.setReorderLevel(item.getReorderLevel());
        return res;
    }
}
