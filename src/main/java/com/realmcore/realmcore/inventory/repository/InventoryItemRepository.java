package com.realmcore.realmcore.inventory.repository;


import com.realmcore.realmcore.inventory.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryItemRepository
        extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByCharacterIdAndItemId(
            Long characterId,
            Long itemId
    );

    List<InventoryItem> findAllByCharacterIdOrderBySlotAsc(
            Long characterId
    );
}