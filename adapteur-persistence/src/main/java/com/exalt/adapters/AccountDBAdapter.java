package com.exalt.adapters;

import com.exalt.data.AccountDto;
import com.exalt.entities.Account;
import com.exalt.mapper.AccountMapper;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDBAdapter implements AccountPersistencePort {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto getAccountByNumber(long accountNumber) {
        Account account = accountRepository.findByaccountNumber(accountNumber);
        return AccountMapper.INSTANCE.toAccountDto(account);
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        Account account = AccountMapper.INSTANCE.toAccountEntity(accountDto);
        return AccountMapper.INSTANCE.toAccountDto(accountRepository.save(account));
    }
}