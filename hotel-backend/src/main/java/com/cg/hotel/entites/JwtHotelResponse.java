package com.cg.hotel.entites;

import java.io.Serializable;

public class JwtHotelResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final Hotel hotel;

	public JwtHotelResponse(String jwttoken, Hotel hotel) {
		this.jwttoken = jwttoken;
		this.hotel = hotel;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public Hotel getHotel() {
		return this.hotel;
	}
	
}
