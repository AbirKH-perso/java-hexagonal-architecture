package com.exalt.adapters;

import com.exalt.data.TransactionDto;
import com.exalt.entities.Transaction;
import com.exalt.ports.spi.TransactionPersistancePort;
import com.exalt.repository.TransactionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TransactionDBAdapter.class})
class TransactionDBAdapterTest {
    @Autowired
    TransactionPersistancePort transactionPersistancePort;
    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void saveTransactionTest() {
        Mockito.when(transactionRepository.save(any(Transaction.class))).thenReturn(new Transaction());
        transactionPersistancePort.saveTransaction(new TransactionDto());
        Mockito.verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    void getAllTransactionsTest() {
        Mockito.when(transactionRepository.findByAccountAccountNumber(123)).thenReturn(new ArrayList<>());
        List<TransactionDto> allTransactions = transactionPersistancePort.getAllTransactions(123);
        Assertions.assertThat(allTransactions).isNotNull();

    }
}