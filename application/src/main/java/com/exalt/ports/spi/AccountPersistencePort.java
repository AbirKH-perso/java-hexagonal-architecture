package com.exalt.ports.spi;

import com.exalt.data.AccountDto;

public interface AccountPersistencePort {
    AccountDto getAccountByNumber(long accountNumber);
}
