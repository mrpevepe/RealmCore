package com.realmcore.realmcore.account.service;

import com.realmcore.realmcore.account.dto.CreateAccountRequest;
import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.model.AccountStatus;
import com.realmcore.realmcore.account.repository.AccountRepository;
import com.realmcore.realmcore.common.exception.UsernameAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    public final AccountRepository accountRepository;
    public final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Account createAccount(CreateAccountRequest request) {
        if (accountRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException();
        }
        Account account = new Account();

        account.setUsername(request.getUsername());
        account.setEmail(request.getEmail());

        String passwordHash = passwordEncoder.encode(request.getPassword());
        account.setPasswordHash(passwordHash);

        account.setStatus(AccountStatus.ACTIVE);
        account.setCreatedAt(LocalDateTime.now());

        return accountRepository.save(account);
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }

}
