package com.application.bankingapplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.bankingapplication.dto.AccountDto;
import com.application.bankingapplication.entity.Account;
import com.application.bankingapplication.service.AccountService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AccountController {
	
	
	private AccountService accountService;
	
	
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "hello";
		
	}
	
	@GetMapping("/Accounts")
	public List<Account> getAllAccount() {
		return accountService.getAll();
		
	}
	
	
    @PostMapping("/Register")
	public ResponseEntity<AccountDto> createAcc(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>( accountService.createAccount(accountDto) , HttpStatus.CREATED);
		
	}
    
    @GetMapping("id")
	public ResponseEntity<Account> getAcc(@RequestParam("id") Long id) {
		return new ResponseEntity<>( accountService.getAccountById(id) , HttpStatus.ACCEPTED);
		
	}
    
    @PutMapping("/{id}/deposit")
   	public ResponseEntity<AccountDto> depositAmout(@PathVariable Long id ,@RequestBody Map<String , Double > request) {
   		AccountDto account = accountService.DepositAmount(id, request.get("amount"));
   		return ResponseEntity.ok(account);
   		
   	}
    
    @PutMapping("/{id}/withdraw")
   	public ResponseEntity<AccountDto> withDrawAmt(@PathVariable Long id ,@RequestBody Map<String , Double > request) {
   		AccountDto account = accountService.WithdrawAmount(id, request.get("amount"));
   		return ResponseEntity.ok(account);
   		
   	}
    
    @PostMapping("/login")
   	public String loginAcc(@RequestBody Account accountDto) {
   		return accountService.verify(accountDto);
   		
   	}
    
    

}
