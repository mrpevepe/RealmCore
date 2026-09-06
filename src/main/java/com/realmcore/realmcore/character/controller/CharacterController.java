package com.realmcore.realmcore.character.controller;

import com.realmcore.realmcore.character.dto.CharacterResponse;
import com.realmcore.realmcore.character.dto.CreateCharacterRequest;
import com.realmcore.realmcore.character.model.Character;
import com.realmcore.realmcore.character.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("/account/{accountId}")
    public ResponseEntity<CharacterResponse> createCharacter(
            @PathVariable Long accountId,
            @Valid @RequestBody CreateCharacterRequest request) {

        Character character = characterService.createCharacter(accountId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CharacterResponse(character));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<CharacterResponse>> getCharactersByAccount(
            @PathVariable Long accountId) {

        List<CharacterResponse> response = characterService.getCharactersByAccount(accountId)
                .stream()
                .map(CharacterResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponse> getCharactersById(
            @PathVariable Long id) {

        Character character = characterService.getCharacterById(id);

        return ResponseEntity.ok(new CharacterResponse(character));
    }

}
