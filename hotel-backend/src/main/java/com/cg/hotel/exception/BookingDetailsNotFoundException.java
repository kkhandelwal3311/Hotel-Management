package com.cg.hotel.exception;

public class BookingDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message;

	public BookingDetailsNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
