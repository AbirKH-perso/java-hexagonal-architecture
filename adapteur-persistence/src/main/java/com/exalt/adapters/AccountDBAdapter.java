package com.exalt.adapters;

import com.exalt.data.AccountDto;
import com.exalt.ports.spi.AccountPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class AccountDBAdapter implements AccountPersistencePort {
    @Override
    public AccountDto getAccountByNumber(long accountNumber) {
        return null;
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        return null;
    }
}