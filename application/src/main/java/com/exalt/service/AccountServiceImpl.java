package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountDepositPort;
import com.exalt.ports.spi.AccountPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountDepositPort {

    @Autowired
    private AccountPersistencePort accountPersistencePort;

    @Override
    public AccountDto deposite(double amount, long accountNumber) {
        return null;
    }
}
