package com.exalt.service;


import com.exalt.ports.api.AccountDepositPort;
import com.exalt.ports.spi.AccountPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AccountServiceImpl.class})
class AccountServiceImplTest {

    @Autowired
    AccountDepositPort accountServicePort;
    @MockBean
    AccountPersistencePort accountPersistencePort;

    @Test
    void deposite() {
        accountServicePort.deposite(100L,1L);
        Mockito.verify(accountPersistencePort,Mockito.atLeastOnce()).getAccountByNumber(1);
    }
}