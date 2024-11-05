package com.application.bankingapplication.exception;

public class AccountNotFoundException extends RuntimeException {



	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	private static final long serialVersionUID = 1L;

	
	public AccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	

}
