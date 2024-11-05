package com.application.bankingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.application.bankingapplication.dto.AccountDto;
import com.application.bankingapplication.entity.Account;
import com.application.bankingapplication.exception.AccountNotFoundException;
import com.application.bankingapplication.mapper.AccountMapper;
import com.application.bankingapplication.repo.AccountRepo;

@Service
public class AccServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTService jwtService;


	@Override
	public AccountDto createAccount(AccountDto account) {
		Account acc = AccountMapper.mapToAccount(account);
		Account save = accountRepo.save(acc);
		return AccountMapper.mapToAccount(save);
		
	}


	@Override
	public Account getAccountById(Long id) {
		
		if(accountRepo.findById(id).isEmpty())
		throw new AccountNotFoundException("Account Id not Vaild");
		return accountRepo.findById(id).get();
	}


	@Override
	public AccountDto DepositAmount(Long id, double Amount) {
		Account acc =	accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account Number Not Found"));
		
		double total = acc.getBalance() + Amount;
		acc.setBalance(total);
		Account save = accountRepo.save(acc);
		return AccountMapper.mapToAccount(save);
	}


	@Override
	public AccountDto WithdrawAmount(Long id, double Amount) {
		Account acc =	accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account Number Not Found"));
		
		if(acc.getBalance() < Amount) {
			throw new RuntimeException("Insuffient balance") ;
		}
		
		double total = acc.getBalance() - Amount;
		acc.setBalance(total);
		Account save = accountRepo.save(acc);
		return AccountMapper.mapToAccount(save);
	}


	@Override
	public String verify(Account accountDto) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDto.getName(), accountDto.getPin()));
		if(auth.isAuthenticated()) {
			return "success";
		} else {
		 throw new RuntimeException("Insuffient balance") ;
	}
	}

}

