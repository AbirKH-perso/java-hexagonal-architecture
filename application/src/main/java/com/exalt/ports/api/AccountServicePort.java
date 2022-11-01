package com.exalt.ports.api;

import com.exalt.data.AccountDto;

public interface AccountServicePort {

    AccountDto createAccount(AccountDto account);
}
