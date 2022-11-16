package com.exalt.ports.spi;

import com.exalt.data.AccountDto;

import java.util.function.DoubleUnaryOperator;

public interface AccountPersistencePort {
    AccountDto saveAccount(AccountDto accountDto);

    AccountDto updateAccountBalance(DoubleUnaryOperator doubleUnaryOperator, long accountNumber);

    boolean accountExists(long accountNumber);
}
