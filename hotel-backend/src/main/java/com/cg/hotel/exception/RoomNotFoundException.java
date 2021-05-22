package com.cg.hotel.exception;

public class RoomNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String message;

	public RoomNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
