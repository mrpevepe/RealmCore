package com.realmcore.realmcore.common.exception;

public class ItemNameAlreadyExistsException extends RuntimeException {

    public ItemNameAlreadyExistsException() {
        super("Item name already exists");
    }
}
