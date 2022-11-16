package com.exalt.adapters;

import com.exalt.data.AccountDto;
import com.exalt.entities.Account;
import com.exalt.mapper.AccountMapper;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.DoubleUnaryOperator;

@Service
public class AccountDBAdapter implements AccountPersistencePort {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        Account account = AccountMapper.INSTANCE.toAccountEntity(accountDto);
        return AccountMapper.INSTANCE.toAccountDto(accountRepository.save(account));
    }

    @Override
    @Transactional
    public AccountDto updateAccountBalance(DoubleUnaryOperator updateOperation, long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setBalance(updateOperation.applyAsDouble(account.getBalance()));
        return AccountMapper.INSTANCE.toAccountDto(account);
    }

    @Override
    public boolean accountExists(long accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }
}