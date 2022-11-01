package com.exalt.controller;


import com.exalt.data.TransactionDto;
import com.exalt.ports.api.TransactionServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionServicePort transactionServicePort;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDto>> getAlltransactions(@PathVariable long accountNumber) {
        return new ResponseEntity<>(transactionServicePort.getAllTransactions(accountNumber), HttpStatus.OK);
    }
}
