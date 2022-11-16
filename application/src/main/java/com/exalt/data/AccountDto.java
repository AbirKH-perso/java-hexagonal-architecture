package com.exalt.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
	@JsonIgnore
	private long id;

	private long accountNumber;

	private Double balance;

	private String accountType;

}