package com.cg.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.Admin;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.repository.AdminRepository;
import com.cg.hotel.repository.HotelRepository;
import com.cg.hotel.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> allUser = userRepository.findAll();
		List<Hotel> allHotel = hotelRepository.findAll();
		List<Admin> allAdmin = adminRepository.findAll();

		for (User user : allUser) {
			if (email.toLowerCase().equals(user.getEmail().toLowerCase())) {
				return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
						new ArrayList<>());
			}
		}
		
		for (Hotel hotel : allHotel) {
			if (email.toLowerCase().equals(hotel.getEmail().toLowerCase())) {
				return new org.springframework.security.core.userdetails.User(hotel.getEmail(), hotel.getPassword(),
						new ArrayList<>());
			}
		}

		for (Admin admin : allAdmin) {
			if (email.toLowerCase().equals(admin.getAdminName().toLowerCase())) {
				return new org.springframework.security.core.userdetails.User(admin.getAdminName(), admin.getPassword(),
						new ArrayList<>());
			}
		}
		
		throw new UserNotFoundException("User not found in Database");
	}

}
