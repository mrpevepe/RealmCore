package com.realmcore.realmcore.item.dto;

import com.realmcore.realmcore.item.model.ItemType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateItemRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @NotNull
    private ItemType type;

    @NotNull
    @Min(1)
    private Integer levelRequired;

    @NotNull
    private Boolean stackable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public Integer getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(Integer levelRequired) {
        this.levelRequired = levelRequired;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public void setStackable(Boolean stackable) {
        this.stackable = stackable;
    }
}
