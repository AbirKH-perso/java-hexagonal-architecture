package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountWithdrawalPort;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.service.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWithdrawalPortImpl implements AccountWithdrawalPort {
    @Autowired
    private AccountPersistencePort accountPersistencePort;

    @Override
    public AccountDto withdrawal(double amount, long accountNumber) {
        AccountDto accountDto = accountPersistencePort.getAccountByNumber(accountNumber);
        AccountDto savedAccount;
        if(accountDto==null) {
            throw new AccountNotFoundException("Account with number: "+accountNumber+" not found!");
        }else {
            accountDto.setBalance(accountDto.getBalance() - amount);
            savedAccount = accountPersistencePort.saveAccount(accountDto);
        }
        return savedAccount;
    }
}
