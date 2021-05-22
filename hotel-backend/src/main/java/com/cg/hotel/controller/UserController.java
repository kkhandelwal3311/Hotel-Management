package com.cg.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.config.JwtTokenUtil;
import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.JwtResponse;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class UserController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	// Endpoint to create or add new User
	@PostMapping("/user/register")
	public User addUser(@Valid @RequestBody User user) {
		logger.info("Entered addUser()");
		return userService.addUser(user);
	}
	
	// Endpoint to update existing user
	@PutMapping("/user")
	public User updateUser(@Valid @RequestBody User user) {
		logger.info("Entered updateUser()");
		return userService.updateUser(user);
	}
	
	// Endpoint to delete existing user by using userId
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<List<User>> removeUser(@PathVariable("userId") int userId){	
		logger.info("Entered removeUser()");
		List<User> allUser = userService.removeUser(userId);
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}
	
	// Endpoint to fetch all users present in database
	@GetMapping("/user")
	public ResponseEntity<List<User>> showAllUsers() {	
		logger.info("Entered showAllUsers()");
		List<User> allUser = userService.showAllUsers();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}
	
	// Endpoint to fetch user by using userId present in database
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> showUser(@PathVariable("userId") int userId){	
		logger.info("Entered showUser()");
		User user = userService.showUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// Endpoint to login user
	@PostMapping("/user/login")
	public ResponseEntity<User> loginUser(@RequestBody User user){	
		logger.info("Entered showUser()");
		User receivedUser = userService.loginUser(user);
		return new ResponseEntity<User>(receivedUser, HttpStatus.OK);
	}
	
	@GetMapping("/user/booking/{userId}")
	public ResponseEntity<List<BookingDetails>> userBooking(@PathVariable("userId") int userId){	
		logger.info("Entered userBooking()");
		List<BookingDetails> userBookingDetails = userService.userBooking(userId);
		return new ResponseEntity<List<BookingDetails>>(userBookingDetails, HttpStatus.OK);
	}
	
	@PostMapping("/user/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserNotFoundException("User Forbidden");
		}
		String token = jwtTokenUtil.generateToken(jwtRequest);
		User receivedUser = userService.loginUserJwt(jwtRequest);
		return new ResponseEntity<>(new JwtResponse(token, receivedUser), HttpStatus.OK);
	}
}
