package com.exalt.service;

import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TransactionServiceImpl.class})
class TransactionServiceImplTest {

    @Autowired
    TransactionServicePort transactionServicePort;


    @Test
    void getAllTransactionsTest() {
       Assertions.assertThat(transactionServicePort.getAllTransactions(123)).isNotNull();
    }
}