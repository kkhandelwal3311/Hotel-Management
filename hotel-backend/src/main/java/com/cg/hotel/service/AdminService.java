package com.cg.hotel.service;

import com.cg.hotel.entites.Admin;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtRequest;

public interface AdminService {

	public Admin signIn(Admin admin);

	public Admin signOut(Admin admin);

	Admin loginAdminJwt(JwtRequest jwtRequest);

}
