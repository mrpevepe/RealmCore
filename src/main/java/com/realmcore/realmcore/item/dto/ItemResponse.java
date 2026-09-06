package com.realmcore.realmcore.item.dto;

import com.realmcore.realmcore.item.model.Item;
import com.realmcore.realmcore.item.model.ItemType;

public class ItemResponse {

    private final Long id;
    private final String name;
    private final ItemType type;
    private final Integer levelRequired;
    private final Boolean stackable;

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.type = item.getType();
        this.levelRequired = item.getLevelRequired();
        this.stackable = item.getStackable();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public Integer getLevelRequired() {
        return levelRequired;
    }

    public Boolean getStackable() {
        return stackable;
    }
}
