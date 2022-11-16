package com.exalt.controller;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServicePort accountServicePort;

    @PostMapping("/deposit")
    public ResponseEntity<AccountDto> deposit(@RequestParam double amount, @RequestParam long accountNumber) {
        return new ResponseEntity<>(accountServicePort.deposit(amount, accountNumber), HttpStatus.OK);
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<AccountDto> withdrawal(@RequestParam double amount, @RequestParam long accountNumber) {
        return new ResponseEntity<>(accountServicePort.withdrawal(amount,accountNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
        return new ResponseEntity<>(accountServicePort.createAccount(account), HttpStatus.OK);
    }

}