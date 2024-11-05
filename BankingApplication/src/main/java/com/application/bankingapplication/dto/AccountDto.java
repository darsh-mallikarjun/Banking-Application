package com.application.bankingapplication.dto;

public class AccountDto {

	
 private Long id;
 
 private String name ;
 
 private double balance;
 
 private String pin;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public String getPin() {
	return pin;
}

public void setPin(String pin) {
	this.pin = pin;
}

public AccountDto(Long id, String name, double balance, String pin) {
	super();
	this.id = id;
	this.name = name;
	this.balance = balance;
	this.pin = pin;
}

public AccountDto(){
	
}
 
 
}
