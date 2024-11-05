package com.application.bankingapplication.service;

import com.application.bankingapplication.dto.AccountDto;
import com.application.bankingapplication.entity.Account;

public interface AccountService {
	
	
	AccountDto createAccount(AccountDto account);
	
	Account getAccountById(Long id);
	
	AccountDto DepositAmount(Long id , double Amount);
	
	AccountDto WithdrawAmount(Long id , double Amount);

	String verify(Account accountDto);

}
