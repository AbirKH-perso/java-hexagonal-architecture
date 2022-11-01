package com.exalt.ports.spi;

import com.exalt.data.TransactionDto;

import java.util.List;


public interface TransactionPersistancePort {

    void saveTransaction(TransactionDto transactionDto);
    List<TransactionDto> getAllTransactions(long accountId);
}
