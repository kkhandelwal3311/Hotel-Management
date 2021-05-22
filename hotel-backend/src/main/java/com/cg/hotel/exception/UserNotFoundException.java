package com.cg.hotel.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public UserNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
