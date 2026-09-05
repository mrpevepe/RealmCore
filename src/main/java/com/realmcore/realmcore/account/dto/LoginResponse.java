package com.realmcore.realmcore.account.dto;

import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.model.AccountStatus;

import java.time.LocalDateTime;

public class LoginResponse {

    private final Long id;
    private final String username;
    private final AccountStatus status;
    private final LocalDateTime lastLogin;

    public LoginResponse(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.status = account.getStatus();
        this.lastLogin = account.getLastLogin();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
}
