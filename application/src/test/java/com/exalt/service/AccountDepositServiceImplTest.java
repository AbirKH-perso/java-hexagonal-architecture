package com.exalt.service;


import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountDepositPort;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.service.exceptions.AccountNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountDepositServiceImpl.class})
class AccountDepositServiceImplTest {

    @Autowired
    AccountDepositPort accountServicePort;
    @MockBean
    AccountPersistencePort accountPersistencePort;

    @Test
    void deposite_successTest() {
        AccountDto accountDto = new AccountDto(1,123,0.0,"courant");
        Mockito.when(accountPersistencePort.getAccountByNumber(123)).thenReturn(accountDto);
        Mockito.when(accountPersistencePort.saveAccount(any(AccountDto.class))).thenAnswer(i -> i.getArguments()[0]);
        AccountDto expectedAccount = accountServicePort.deposite(100L, 123);
        Assertions.assertThat(expectedAccount.getBalance()).isEqualTo(100);
    }

    @Test
    void deposite_exceptionTest() {
        Mockito.when(accountPersistencePort.getAccountByNumber(123)).thenReturn(null);
        Assertions.assertThatThrownBy(() -> accountServicePort.deposite(100L, 123))
                .isInstanceOf(AccountNotFoundException.class).hasMessageContaining("not found");
    }

}