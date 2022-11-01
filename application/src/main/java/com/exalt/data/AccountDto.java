package com.exalt.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

	private long id;

	private long accountNumber;

	private Double balance;

	private String accounttype;
}