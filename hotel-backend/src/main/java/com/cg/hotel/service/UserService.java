package com.cg.hotel.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.User;

public interface UserService {
	public User addUser(User user);

	public User updateUser(User user);

	public List<User> removeUser(int userId);

	public List<User> showAllUsers();

	public User showUser(int userId);

	public User loginUser(User user);

	public User loginUserJwt(JwtRequest jwtRequest);
	
	public List<BookingDetails> userBooking(int userId);
}
