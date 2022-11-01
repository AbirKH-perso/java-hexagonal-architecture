package com.exalt.service;

import com.exalt.data.TransactionDto;
import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionServicePort {

    @Autowired
    private TransactionPersistancePort transactionPersistancePort;


    @Override
    public List<TransactionDto> getAllTransactions(long accountNumber) {
        return transactionPersistancePort.getAllTransactions(accountNumber);
    }
}
