package com.exalt.ports.api;

import com.exalt.data.AccountDto;

public interface AccountWithdrawalPort {
    AccountDto withdrawal(double amount, long accountNumber);
}
