package com.exalt.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {

  private double amount;


  private AccountDto account;


  private String transactionInfo;

  public TransactionDto(String info, double amount, AccountDto accounts) {
    this.transactionInfo = info;
    this.amount = amount;
    this.account = accounts;
  }
}