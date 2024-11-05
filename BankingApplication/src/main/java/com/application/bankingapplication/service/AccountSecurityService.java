package com.application.bankingapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.bankingapplication.entity.Account;

import com.application.bankingapplication.entity.AccPrincpla;
import com.application.bankingapplication.repo.AccountRepo;

@Service
public class AccountSecurityService implements UserDetailsService {
	
	
	@Autowired
	private AccountRepo accountRepo;


	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Account acc = accountRepo.findByname(name);
		if(acc == null) {
			System.out.println("User Not found");
			throw new UsernameNotFoundException("user not find");
		}
		
		return new AccPrincpla(acc);
	}

}
