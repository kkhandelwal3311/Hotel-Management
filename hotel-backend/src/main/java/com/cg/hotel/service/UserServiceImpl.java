package com.cg.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.BookingDetailsNotFoundException;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.repository.BookingDetailsRepository;
import com.cg.hotel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	// method to add new user
	@Override
	public User addUser(User user) {
		logger.info("Entered service addUser()");
		return userRepository.save(user);
	}

	// method to update existing user
	@Override
	public User updateUser(User user) {
		logger.info("Entered service updateUser()");
		return userRepository.save(user);
	}

	// method to delete existing user
	@Override
	public List<User> removeUser(int userId) {
		logger.info("Entered service removeUser()");
		// EmptyResultDataAccessException
		try {
			userRepository.deleteById(userId);
		} catch (Exception e) {
			throw new UserNotFoundException("User Id not found");
		}
		return userRepository.findAll();
	}

	// method to fetch all the user
	@Override
	public List<User> showAllUsers() {
		logger.info("Entered service showAllUsers()");
		List<User> allUser = userRepository.findAll();
		if (allUser.isEmpty()) {
			throw new UserNotFoundException("Users not found");
		}
		return allUser;
	}

	// method to fetch user by using userId
	@Override
	public User showUser(int userId) {
		logger.info("Entered service showUser()");
		Optional<User> temporaryUser = userRepository.findById(userId);
		if (temporaryUser.isPresent()) {
			return temporaryUser.get();
		} else {
			throw new UserNotFoundException("User not found by userId");
		}
	}

	// method to login user using email and password
	@Override
	public User loginUser(User user) {
		logger.info("Entered service loginUser()");
		List<User> allUser = userRepository.findAll();

		for (User oneUser : allUser) {
			if (user.getEmail().toLowerCase().equals(oneUser.getEmail().toLowerCase())) {
				if (user.getPassword().equals(oneUser.getPassword())) {
					return oneUser;
				}
				throw new UserNotFoundException("Please check password");
			}
		}
		throw new UserNotFoundException("User not found by please check email password");
	}

	@Override
	public User loginUserJwt(JwtRequest jwtRequest) {
		// TODO Auto-generated method stub
		logger.info("Entered service loginUserJwt()");
		List<User> allUser = userRepository.findAll();

		for (User oneUser : allUser) {
			if (jwtRequest.getEmail().toLowerCase().equals(oneUser.getEmail().toLowerCase())) {
				if (jwtRequest.getPassword().equals(oneUser.getPassword())) {
					return oneUser;
				}
				throw new UserNotFoundException("Please check password");
			}
		}
		throw new UserNotFoundException("User not found please check email password");
	}

	@Override
	public List<BookingDetails> userBooking(int userId) {
		// TODO Auto-generated method stub
		logger.info("Entered service userBooking()");
		List<BookingDetails> allBookings = bookingDetailsRepository.findAll();
		List<BookingDetails> userBookingDetails = new ArrayList<>();

		if (allBookings.isEmpty()) {
			throw new BookingDetailsNotFoundException("Booking details not found");
		}
		
		for (int i = 0; i < allBookings.size(); i++) {
			if(allBookings.get(i).getUserId().getUserId() == userId) {
				userBookingDetails.add(allBookings.get(i));
			}
		}
		
		if (userBookingDetails.isEmpty()) {
			throw new BookingDetailsNotFoundException("User has not done Booking");
		}

		return userBookingDetails;
	}
}
