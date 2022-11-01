package com.exalt.mapper;

import com.exalt.data.TransactionDto;
import com.exalt.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toTransactionEntity(TransactionDto transactionDto);

    List<TransactionDto> toTransactionDtoList(List<Transaction> transaction);
}
