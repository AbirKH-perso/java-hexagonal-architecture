package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.data.TransactionDto;
import com.exalt.ports.api.AccountServicePort;
import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.service.exceptions.AccountExistsAlreadyException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountServicePortImpl implements AccountServicePort {

    private static final String DEPOSIT_TRANSACTION = "deposit";
    private static final String WITHDRAWAL_TRANSACTION = "withdrawal";

    private final AccountPersistencePort accountPersistencePort;

    private final TransactionServicePort transactionServicePort;

    @Override
    public AccountDto createAccount(AccountDto account) {
        accountExists(account.getAccountNumber());
        return accountPersistencePort.saveAccount(account);
    }

    @Override
    public AccountDto withdrawal(double amount, long accountNumber) {
        AccountDto accountDto = accountPersistencePort.updateAccountBalance((actualBalance) -> actualBalance - amount, accountNumber);
        transactionServicePort.saveTransaction(new TransactionDto(DEPOSIT_TRANSACTION, amount, accountDto));
        return accountDto;
    }

    @Override
    public AccountDto deposit(double amount, long accountNumber) {
        AccountDto accountDto = accountPersistencePort.updateAccountBalance((actualBalance) -> actualBalance + amount, accountNumber);
        transactionServicePort.saveTransaction(new TransactionDto(WITHDRAWAL_TRANSACTION, amount, accountDto));
        return accountDto;
    }


    private void accountExists(Long accountNumber) {
        if (accountPersistencePort.accountExists(accountNumber))
            throw new AccountExistsAlreadyException("account with this number exists already!");
    }


}
