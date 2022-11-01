package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountServicePort;
import com.exalt.ports.spi.AccountPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountServicePortImpl.class})
class AccountServicePortImplTest {
    @Autowired
    AccountServicePort accountServicePort;
    @MockBean
    AccountPersistencePort accountPersistencePort;

    @Test
    void createAccount(){
        accountServicePort.createAccount(new AccountDto());
        Mockito.verify(accountPersistencePort,Mockito.atLeastOnce()).saveAccount(any(AccountDto.class));
    }
}