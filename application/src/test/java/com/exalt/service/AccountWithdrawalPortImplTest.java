package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountWithdrawalPort;
import com.exalt.ports.spi.AccountPersistencePort;
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
@ContextConfiguration(classes = {AccountWithdrawalPortImpl.class})
class AccountWithdrawalPortImplTest {
    @Autowired
    AccountWithdrawalPort accountWithdrawalPort;
    @MockBean
    AccountPersistencePort accountPersistencePort;

    @Test
    void withdrawalTest() {
        AccountDto accountDto = new AccountDto(1,123,0.0,"courant");
        Mockito.when(accountPersistencePort.getAccountByNumber(123)).thenReturn(accountDto);
        Mockito.when(accountPersistencePort.saveAccount(any(AccountDto.class))).thenAnswer(i -> i.getArguments()[0]);
        AccountDto expectedAccount = accountWithdrawalPort.withdrawal(100L, 123);
        Assertions.assertThat(expectedAccount).isNotNull();
    }
}