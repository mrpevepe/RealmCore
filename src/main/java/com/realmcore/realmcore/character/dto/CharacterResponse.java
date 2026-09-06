package com.realmcore.realmcore.character.dto;

import com.realmcore.realmcore.character.model.Character;

import java.time.LocalDateTime;

public class CharacterResponse {

    private final Long id;
    private final String name;
    private final Integer level;
    private final Long experience;
    private final LocalDateTime createdAt;
    private final Long accountId;

    public CharacterResponse(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.level = character.getLevel();
        this.experience = character.getExperience();
        this.createdAt = character.getCreatedAt();
        this.accountId = character.getAccount().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Long getExperience() {
        return experience;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getAccountId() {
        return accountId;
    }
}
