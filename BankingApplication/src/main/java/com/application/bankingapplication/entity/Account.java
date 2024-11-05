package com.application.bankingapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accno")
	private Long id;
	
	@Column(name = "holder")
	private String name;
	
	 private double balance;
	
	private String pin;


public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

	
	

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

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Account(Long id, String name, double balance, String pin) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.pin = pin;
	}

	public Account() {
		
	}
	
	
}


