package com.realmcore.realmcore.item.controller;

import com.realmcore.realmcore.item.dto.CreateItemRequest;
import com.realmcore.realmcore.item.dto.ItemResponse;
import com.realmcore.realmcore.item.model.Item;
import com.realmcore.realmcore.item.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(
            @Valid @RequestBody CreateItemRequest request) {

        Item item = itemService.createItem(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ItemResponse(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(
            @PathVariable Long id) {

        Item item = itemService.getItemById(id);

        return ResponseEntity.ok(new ItemResponse(item));
    }
}
