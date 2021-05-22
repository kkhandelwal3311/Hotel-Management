package com.cg.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.Admin;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.exception.AdminNotFoundException;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	// method to signin Admin
	@Override
	public Admin signIn(Admin admin) {
		logger.info("Entered service loginUser()");
		List<Admin> allAdmin = adminRepository.findAll();
		for (Admin oneAdmin : allAdmin) {
			if (admin.getAdminName().toLowerCase().equals(oneAdmin.getAdminName().toLowerCase())) {
				if (admin.getPassword().equals(oneAdmin.getPassword())) {
					return oneAdmin;
				}
				throw new AdminNotFoundException("Please check password");
			}
			throw new AdminNotFoundException("Please check name");
		}
		throw new AdminNotFoundException("User not found by please check email password");
	}

	// method to Signout Admin
	@Override
	public Admin signOut(Admin admin) {
		logger.info("Entered service signOut()");
		return adminRepository.findById(admin.getAdminId()).get();
	}
	
	@Override
	public Admin loginAdminJwt(JwtRequest jwtRequest) {
		// TODO Auto-generated method stub
		List<Admin> allAdmin = adminRepository.findAll();

		for (Admin oneAdmin : allAdmin) {
			if (jwtRequest.getEmail().toLowerCase().equals(oneAdmin.getAdminName().toLowerCase())) {
				if (jwtRequest.getPassword().equals(oneAdmin.getPassword())) {
					return oneAdmin;
				}
				throw new AdminNotFoundException("Please check password");
			}
		}
		throw new AdminNotFoundException("Admin not found please check email password");
	}

}
