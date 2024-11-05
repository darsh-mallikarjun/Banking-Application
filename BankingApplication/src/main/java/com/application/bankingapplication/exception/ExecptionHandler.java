package com.application.bankingapplication.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExecptionHandler {
	
	
	@ExceptionHandler(value = {AccountNotFoundException.class})
	public ResponseEntity<Object> handleBookNotFoundException(AccountNotFoundException bookNotFoundException){
		
		AccountsException bookException = new AccountsException(
				
				bookNotFoundException.getMessage(),
				bookNotFoundException.getCause(),
				HttpStatus.NOT_FOUND
				);
		
		return new ResponseEntity<>(bookException , HttpStatus.NOT_FOUND);
	}
	

}
