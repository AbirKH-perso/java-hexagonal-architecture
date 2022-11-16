package com.exalt.config;

import com.exalt.adapters.AccountDBAdapter;
import com.exalt.adapters.TransactionDBAdapter;
import com.exalt.ports.api.AccountServicePort;
import com.exalt.ports.api.TransactionServicePort;
import com.exalt.ports.spi.AccountPersistencePort;
import com.exalt.ports.spi.TransactionPersistancePort;
import com.exalt.service.AccountServicePortImpl;
import com.exalt.service.TransactionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public AccountPersistencePort getAccountPersistencePort(){
        return new AccountDBAdapter();
    }

    @Bean
    AccountServicePort getAccountServicePort(){
        return new AccountServicePortImpl(getAccountPersistencePort(),transactionServicePort());
    }
    @Bean
    TransactionServicePort transactionServicePort(){
        return new TransactionServiceImpl(transactionPersistancePort());
    }

    @Bean
    public TransactionPersistancePort transactionPersistancePort(){
        return new TransactionDBAdapter();
    }

}
