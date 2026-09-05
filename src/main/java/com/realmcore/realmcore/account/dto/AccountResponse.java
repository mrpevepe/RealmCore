package com.realmcore.realmcore.account.dto;

import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.model.AccountStatus;

import java.time.LocalDateTime;

public class AccountResponse {
    private Long id;
    private String username;
    private String email;
    private AccountStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    public AccountResponse(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.email = account.getEmail();
        this.status = account.getStatus();
        this.createdAt = account.getCreatedAt();
        this.lastLogin = account.getLastLogin();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
}
