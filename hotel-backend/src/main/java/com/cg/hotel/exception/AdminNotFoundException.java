package com.cg.hotel.exception;

public class AdminNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	String message;

	public AdminNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
