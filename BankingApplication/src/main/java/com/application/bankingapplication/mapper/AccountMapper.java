package com.application.bankingapplication.mapper;

import com.application.bankingapplication.dto.AccountDto;
import com.application.bankingapplication.entity.Account;

public class AccountMapper {
	
	public  static Account mapToAccount(AccountDto accountDto) {
		Account acc = new Account(
				accountDto.getId(),
				accountDto.getName(),
				accountDto.getBalance(),
				accountDto.getPin()	
	);
		
		return acc;
		
	}
	
	
	public  static AccountDto mapToAccount(Account account) {
		AccountDto acc = new AccountDto(
				account.getId(),
				account.getName(),
				account.getBalance(),
				account.getPin()	
	);
		
		return acc;
		
	}

}
