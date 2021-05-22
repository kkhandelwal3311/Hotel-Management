package com.cg.hotel.exception;

public class TransactionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message;

	public TransactionNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
