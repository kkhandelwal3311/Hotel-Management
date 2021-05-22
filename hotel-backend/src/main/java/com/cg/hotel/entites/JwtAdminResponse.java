package com.cg.hotel.entites;

import java.io.Serializable;

public class JwtAdminResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final Admin admin;

	public JwtAdminResponse(String jwttoken, Admin admin) {
		this.jwttoken = jwttoken;
		this.admin = admin;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public Admin getAdmin() {
		return this.admin;
	}
	
}