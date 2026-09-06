package com.realmcore.realmcore.common.exception;

public class CharacterNameAlreadyExistsException extends RuntimeException {

    public CharacterNameAlreadyExistsException() {
        super("Character name already exists");
    }
}
