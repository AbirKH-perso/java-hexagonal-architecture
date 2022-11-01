package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountDepositPort;
import org.springframework.stereotype.Service;

@Service
public class AccountDepositServiceImpl extends AccountBalance implements AccountDepositPort {

    @Override
    public AccountDto deposite(double amount, long accountNumber) {
        return super.setBalance(amount,accountNumber);
    }

    @Override
    public String getTransactionMessage() {
        return "deposite to account";
    }

    @Override
    public Double getBalance(double amount, AccountDto accountDto) {
        return accountDto.getBalance() + amount;
    }
}
