package com.exalt.repository;

import com.exalt.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByaccountNumber(long accountNumber);
}
