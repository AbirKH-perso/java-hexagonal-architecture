package com.exalt.service;


import com.exalt.data.AccountDto;
import com.exalt.data.TransactionDto;
import com.exalt.ports.api.AccountServicePort;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.function.DoubleUnaryOperator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountServicePortImpl.class,TransactionServiceImpl.class})
class AccountServicePortImplTest {

    @Autowired
    AccountServicePort accountServicePort;
    @MockBean
    AccountPersistencePort accountPersistencePort;

    @MockBean
    TransactionPersistancePort transactionPersistancePort;

    @Test
    void deposit_successTest() {
        AccountDto accountDto = new AccountDto(1,123,100.0,"courant");
        Mockito.when(accountPersistencePort.updateAccountBalance(any(DoubleUnaryOperator.class), anyLong())).thenReturn(accountDto);
        AccountDto expectedAccount = accountServicePort.deposit(100,123L );
        Assertions.assertThat(expectedAccount.getBalance()).isEqualTo(100);
        Mockito.verify(transactionPersistancePort).saveTransaction(any(TransactionDto.class));
    }


    @Test
    void createAccount(){
        accountServicePort.createAccount(new AccountDto());
        Mockito.verify(accountPersistencePort,Mockito.atLeastOnce()).saveAccount(any(AccountDto.class));
    }


}