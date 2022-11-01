package com.exalt.controller;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountDepositPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountDepositPort accountDepositPort;

    @PostMapping("/deposite")
    public ResponseEntity<AccountDto> deposite(@RequestParam double amount, @RequestParam long accountNumber){
        return  new ResponseEntity<>( accountDepositPort.deposite(amount, accountNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account){
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}