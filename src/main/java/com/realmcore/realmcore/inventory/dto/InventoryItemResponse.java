package com.realmcore.realmcore.inventory.dto;

import com.realmcore.realmcore.inventory.model.InventoryItem;

public class InventoryItemResponse {

    private final Long itemId;
    private final String itemName;
    private final Integer quantity;
    private final Integer slot;

    public InventoryItemResponse(InventoryItem inventoryItem) {
        this.itemId = inventoryItem.getItem().getId();
        this.itemName = inventoryItem.getItem().getName();
        this.quantity = inventoryItem.getQuantity();
        this.slot = inventoryItem.getSlot();
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getSlot() {
        return slot;
    }
}
