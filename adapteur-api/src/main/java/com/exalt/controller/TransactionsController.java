package com.exalt.controller;

import com.exalt.data.TransactionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {


    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDto>> getAlltransactions(@PathVariable long accountNumber) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
