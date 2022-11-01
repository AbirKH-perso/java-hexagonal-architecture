package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountServicePort;
import com.exalt.ports.spi.AccountPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServicePortImpl implements AccountServicePort {
    @Autowired
    private AccountPersistencePort accountPersistencePort;

    @Override
    public AccountDto createAccount(AccountDto account) {
        return accountPersistencePort.saveAccount(account);
    }
}
