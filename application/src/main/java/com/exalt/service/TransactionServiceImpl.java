package com.exalt.service;

import com.exalt.data.TransactionDto;
import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionServicePort {

    private final TransactionPersistancePort transactionPersistancePort;


    @Override
    public List<TransactionDto> getAllTransactions(long accountNumber) {
        return transactionPersistancePort.getAllTransactions(accountNumber);
    }

    @Override
    public void saveTransaction(TransactionDto transaction) {
        transactionPersistancePort.saveTransaction(transaction);
    }
}
