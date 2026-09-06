package com.realmcore.realmcore.item.service;

import com.realmcore.realmcore.common.exception.ItemNameAlreadyExistsException;
import com.realmcore.realmcore.item.dto.CreateItemRequest;
import com.realmcore.realmcore.item.model.Item;
import com.realmcore.realmcore.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(CreateItemRequest request) {

        if (itemRepository.findByName(request.getName()).isPresent()) {
            throw new ItemNameAlreadyExistsException();
        }

        Item item = new Item();

        item.setName(request.getName());
        item.setType(request.getType());
        item.setLevelRequired(request.getLevelRequired());
        item.setStackable(request.getStackable());

        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {

        return itemRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item not found"));
    }

}
