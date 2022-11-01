package com.exalt.mapper;

import com.exalt.data.AccountDto;
import com.exalt.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toAccountDto(Account account);

    Account toAccountEntity(AccountDto accountDto);

}