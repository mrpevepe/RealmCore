package com.realmcore.realmcore.item.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "items",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_item_name",
                        columnNames = "name"
                )
        }
)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType type;

    @Column(nullable = false)
    private Integer levelRequired;

    @Column(nullable = false)
    private Boolean stackable;

    public Long getId() {
        return id;
    }

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
