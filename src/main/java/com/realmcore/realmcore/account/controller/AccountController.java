package com.realmcore.realmcore.account.controller;

import com.realmcore.realmcore.account.dto.AccountResponse;
import com.realmcore.realmcore.account.dto.CreateAccountRequest;
import com.realmcore.realmcore.account.model.Account;
import com.realmcore.realmcore.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    public final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(
            @Valid @RequestBody CreateAccountRequest request) {
        Account account = accountService.createAccount(request);

        AccountResponse response = new AccountResponse(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
