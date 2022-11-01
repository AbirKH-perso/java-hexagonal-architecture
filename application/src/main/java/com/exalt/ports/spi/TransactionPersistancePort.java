package com.exalt.ports.spi;

import com.exalt.data.TransactionDto;


public interface TransactionPersistancePort {

    void saveTransaction(TransactionDto transactionDto);

}
