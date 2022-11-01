package com.exalt.mapper;

import com.exalt.data.TransactionDto;
import com.exalt.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toTransactionEntity(TransactionDto transactionDto);
}
