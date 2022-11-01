package com.exalt.adapters;

import com.exalt.data.TransactionDto;
import com.exalt.ports.spi.TransactionPersistancePort;
import com.exalt.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDBAdapter implements TransactionPersistancePort {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
    }

    @Override
    public List<TransactionDto> getAllTransactions(long accountId) {
        return null;
    }



}
