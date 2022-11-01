package com.exalt.controller;

import com.exalt.data.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @PostMapping("/deposite")
    public ResponseEntity<AccountDto> deposite(@RequestParam double amount, @RequestParam long accountNumber){
        return  new ResponseEntity<>( null, HttpStatus.NOT_FOUND);
    }

}