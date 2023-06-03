package com.ak.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PaymentNotFountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public PaymentNotFountException() {
	super();
}
public PaymentNotFountException(String msg) {
	super(msg);
}

}
