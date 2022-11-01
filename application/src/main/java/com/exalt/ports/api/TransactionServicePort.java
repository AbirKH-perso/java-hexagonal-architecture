package com.exalt.ports.api;

import com.exalt.data.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionServicePort {
    List<TransactionDto> getAllTransactions(long accountNumber);
}
