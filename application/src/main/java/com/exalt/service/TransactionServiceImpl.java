package com.exalt.service;

import com.exalt.data.TransactionDto;
import com.exalt.ports.api.TransactionServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionServicePort {

    @Override
    public List<TransactionDto> getAllTransactions(long accountNumber) {
        return null;
    }
}
