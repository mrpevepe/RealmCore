package com.realmcore.realmcore.inventory.controller;

import com.realmcore.realmcore.inventory.dto.AddItemRequest;
import com.realmcore.realmcore.inventory.dto.InventoryItemResponse;
import com.realmcore.realmcore.inventory.model.InventoryItem;
import com.realmcore.realmcore.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters/{characterId}/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/items")
    public ResponseEntity<List<InventoryItemResponse>> addItem(
            @PathVariable Long characterId,
            @Valid @RequestBody AddItemRequest request) {

        List<InventoryItem> inventoryItems =
                inventoryService.addItem(
                        characterId,
                        request
                );

        List<InventoryItemResponse> response =
                inventoryItems.stream()
                        .map(InventoryItemResponse::new)
                        .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemResponse>> getInventory(
            @PathVariable Long characterId) {

        List<InventoryItemResponse> response = inventoryService
                .getInventory(characterId)
                .stream()
                .map(InventoryItemResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }
}
