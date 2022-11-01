package com.exalt.service;

import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TransactionServiceImpl.class})
class TransactionServiceImplTest {

    @Autowired
    TransactionServicePort transactionServicePort;
    @MockBean
    private TransactionPersistancePort transactionPersistancePort;

    @Test
    void getAllTransactionsTest() {
        Mockito.when(transactionPersistancePort.getAllTransactions(123)).thenReturn(Collections.emptyList());
       Assertions.assertThat(transactionServicePort.getAllTransactions(123)).isNotNull();
    }
}