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
    void updateAccountBalanceTest() {
        Mockito.when(accountRepository.findByAccountNumber(1L)).thenReturn(new Account(1L,2.0D,"courant",null));
        AccountDto accountDto = accountPersistencePort.updateAccountBalance(a->a+3,1L);
        Assertions.assertThat(accountDto.getBalance()).isEqualTo(5.0);
    }

    @Test
    void saveAccountTest() {
        accountPersistencePort.saveAccount(new AccountDto());
        Mockito.verify(accountRepository).save(any(Account.class));
    }
}