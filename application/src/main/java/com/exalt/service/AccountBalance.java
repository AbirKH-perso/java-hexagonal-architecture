package com.exalt.service;

import com.exalt.data.AccountDto;
import com.exalt.data.TransactionDto;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import com.exalt.service.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AccountBalance {

    @Autowired
    private AccountPersistencePort accountPersistencePort;
    @Autowired
    private TransactionPersistancePort transactionPersistancePort;

    public AccountDto setBalance(double amount, long accountNumber) {
        AccountDto accountDto = accountPersistencePort.getAccountByNumber(accountNumber);
        AccountDto savedAccount;
        if(accountDto==null) {
            throw new AccountNotFoundException("Account with number: "+accountNumber+" not found!");
        }else {
            accountDto.setBalance(getBalance(amount, accountDto));
            savedAccount = accountPersistencePort.saveAccount(accountDto);
            TransactionDto transactionDto=new TransactionDto(getTransactionMessage(),amount,accountDto);
            transactionPersistancePort.saveTransaction(transactionDto);
        }
        return savedAccount;
    }

    public abstract String getTransactionMessage() ;

    public abstract Double getBalance(double amount, AccountDto accountDto) ;

}
