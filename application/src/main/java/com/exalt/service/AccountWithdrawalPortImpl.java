package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountWithdrawalPort;

import org.springframework.stereotype.Service;

@Service
public class AccountWithdrawalPortImpl extends AccountBalance implements AccountWithdrawalPort {

    @Override
    public AccountDto withdrawal(double amount, long accountNumber) {
        return super.setBalance(amount,accountNumber);
    }
    @Override
    public Double getBalance(double amount, AccountDto accountDto) {
        return accountDto.getBalance() - amount;
    }

}
