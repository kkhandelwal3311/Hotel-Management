package com.cg.hotel.exception;

public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message;

	public PaymentNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
