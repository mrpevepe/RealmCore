package com.realmcore.realmcore.character.repository;

import com.realmcore.realmcore.character.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    Optional<Character> findByName(String name);

    List<Character> findAllByAccountId(Long accountId);
}
