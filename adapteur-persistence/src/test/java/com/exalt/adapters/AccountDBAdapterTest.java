package com.exalt.adapters;

import com.exalt.data.AccountDto;
import com.exalt.entities.Account;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.repository.AccountRepository;
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
@ContextConfiguration(classes = {AccountDBAdapter.class})
class AccountDBAdapterTest {
    @Autowired
    AccountPersistencePort accountPersistencePort;
    @MockBean
    private AccountRepository accountRepository;

    @Test
    void getAccountByNumberTest() {
        Mockito.when(accountRepository.findByaccountNumber(1L)).thenReturn(new Account());
        AccountDto accountDto = accountPersistencePort.getAccountByNumber(1L);
        Assertions.assertThat(accountDto).isNotNull();
    }

    @Test
    void saveAccountTest() {
        accountPersistencePort.saveAccount(new AccountDto());
        Mockito.verify(accountRepository).save(any(Account.class));
    }
}