package com.application.bankingapplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.bankingapplication.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	
	

	Account findBypin(String pin);

	Account findByname(String name);

}
