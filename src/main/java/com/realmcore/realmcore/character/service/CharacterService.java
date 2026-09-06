package com.realmcore.realmcore.character.service;

import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.repository.AccountRepository;
import com.realmcore.realmcore.character.dto.CreateCharacterRequest;
import com.realmcore.realmcore.character.model.Character;
import com.realmcore.realmcore.character.repository.CharacterRepository;
import com.realmcore.realmcore.common.exception.CharacterNameAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final AccountRepository accountRepository;

    public CharacterService(
            CharacterRepository characterRepository,
            AccountRepository accountRepository) {

        this.characterRepository = characterRepository;
        this.accountRepository = accountRepository;
    }

    public Character createCharacter(
            Long accountId,
            CreateCharacterRequest request) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (characterRepository.findByName(request.getName()).isPresent()) {
            throw new CharacterNameAlreadyExistsException();
        }

        com.realmcore.realmcore.character.model.Character character = new Character();

        character.setName(request.getName());
        character.setLevel(1);
        character.setExperience(0L);
        character.setCreatedAt(LocalDateTime.now());
        character.setAccount(account);

        return characterRepository.save(character);
    }

    public List<Character> getCharactersByAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Account not Found");
        }

        return characterRepository.findAllByAccountId(accountId);
    }

    public Character getCharacterById(Long id) {

        return characterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Character not found"));
    }

}
