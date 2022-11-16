package com.exalt.ports.api;

import com.exalt.data.AccountDto;

public interface AccountServicePort {

    AccountDto createAccount(AccountDto account);
    AccountDto withdrawal(double amount, long accountNumber);
    AccountDto deposit(double amount, long accountNumber);

}
