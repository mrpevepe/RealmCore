package com.realmcore.realmcore.auth.service;

import com.realmcore.realmcore.account.dto.LoginRequest;
import com.realmcore.realmcore.account.dto.LoginResponse;
import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.model.AccountStatus;
import com.realmcore.realmcore.account.repository.AccountRepository;
import com.realmcore.realmcore.common.exception.InvalidCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            AccountRepository accountRepository,
            PasswordEncoder passwordEncoder) {

        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {

        Account account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(InvalidCredentialsException::new);

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalArgumentException("Account is not active");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                account.getPasswordHash())) {

            throw new InvalidCredentialsException();
        }

        account.setLastLogin(LocalDateTime.now());

        accountRepository.save(account);

        return new LoginResponse(account);
    }
}
