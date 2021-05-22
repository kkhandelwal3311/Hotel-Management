package com.cg.hotel.exception;

public class HotelNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message;

	public HotelNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
