package com.exalt.ports.api;

import com.exalt.data.AccountDto;

public interface AccountDepositPort {

    AccountDto deposite(double amount, long accountNumber);
}
