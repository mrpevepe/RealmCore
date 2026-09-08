package com.realmcore.realmcore.inventory.service;

import com.realmcore.realmcore.character.model.Character;
import com.realmcore.realmcore.character.repository.CharacterRepository;
import com.realmcore.realmcore.inventory.dto.AddItemRequest;
import com.realmcore.realmcore.inventory.model.InventoryItem;
import com.realmcore.realmcore.inventory.repository.InventoryItemRepository;
import com.realmcore.realmcore.item.model.Item;
import com.realmcore.realmcore.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final CharacterRepository characterRepository;
    private final ItemRepository itemRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private static final int MAX_SLOTS = 36;

    public InventoryService(
            CharacterRepository characterRepository,
            ItemRepository itemRepository,
            InventoryItemRepository inventoryItemRepository) {

        this.characterRepository = characterRepository;
        this.itemRepository = itemRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Transactional
    public List<InventoryItem> addItem(
            Long characterId,
            AddItemRequest request) {

        Character character = characterRepository.findById(characterId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Character not found"));

        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));

        List<InventoryItem> inventory =
                inventoryItemRepository
                        .findAllByCharacterIdOrderBySlotAsc(characterId);

        if (item.getStackable()) {

            InventoryItem existingItem =
                    inventoryItemRepository
                            .findByCharacterIdAndItemId(
                                    characterId,
                                    item.getId()
                            )
                            .orElse(null);

            if (existingItem != null) {

                existingItem.setQuantity(
                        existingItem.getQuantity()
                                + request.getQuantity()
                );

                return List.of(
                        inventoryItemRepository.save(existingItem)
                );
            }

            int slot = findFirstAvailableSlot(inventory);

            InventoryItem inventoryItem = new InventoryItem();

            inventoryItem.setCharacter(character);
            inventoryItem.setItem(item);
            inventoryItem.setQuantity(request.getQuantity());
            inventoryItem.setSlot(slot);

            return List.of(
                    inventoryItemRepository.save(inventoryItem)
            );
        }

        int requiredSlots = request.getQuantity();

        int availableSlots = MAX_SLOTS - inventory.size();

        if (requiredSlots > availableSlots) {
            throw new IllegalArgumentException(
                    "Not enough inventory space"
            );
        }

        List<InventoryItem> createdItems = new java.util.ArrayList<>();

        java.util.Set<Integer> occupiedSlots = inventory.stream()
                .map(InventoryItem::getSlot)
                .collect(java.util.stream.Collectors.toSet());

        for (int i = 0; i < requiredSlots; i++) {

            int slot = findFirstAvailableSlot(occupiedSlots);

            InventoryItem inventoryItem = new InventoryItem();

            inventoryItem.setCharacter(character);
            inventoryItem.setItem(item);
            inventoryItem.setQuantity(1);
            inventoryItem.setSlot(slot);

            createdItems.add(inventoryItem);

            occupiedSlots.add(slot);
        }

        return inventoryItemRepository.saveAll(createdItems);
    }

    public List<InventoryItem> getInventory(Long characterId) {

        if (!characterRepository.existsById(characterId)) {
            throw new IllegalArgumentException("Character not found");
        }

        return inventoryItemRepository
                .findAllByCharacterIdOrderBySlotAsc(characterId);
    }

    private int findFirstAvailableSlot(
            List<InventoryItem> inventory) {

        java.util.Set<Integer> occupiedSlots = inventory.stream()
                .map(InventoryItem::getSlot)
                .collect(java.util.stream.Collectors.toSet());

        return findFirstAvailableSlot(occupiedSlots);
    }

    private int findFirstAvailableSlot(
            java.util.Set<Integer> occupiedSlots) {

        for (int slot = 1; slot <= MAX_SLOTS; slot++) {

            if (!occupiedSlots.contains(slot)) {
                return slot;
            }
        }

        throw new IllegalArgumentException(
                "Inventory is full"
        );
    }
}
