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
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtHotelResponse;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.JwtResponse;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.service.HotelService;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	Logger logger = LoggerFactory.getLogger(HotelController.class);

	// Endpoint to create or add new Hotel
	@PostMapping("/hotel/register")
	public Hotel addHotel(@Valid @RequestBody Hotel hotel) {
		logger.info("Entered addHotel()");
		return hotelService.addHotel(hotel);
	}

	// Endpoint to update existing Hotel details
	@PutMapping("/hotel")
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		logger.info("Entered updateHotel()");
		return hotelService.updateHotel(hotel);
	}

	// Endpoint to delete existing Hotel details by using hotelId
	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Hotel>> removeHotel(@PathVariable("hotelId") int hotelId) throws HotelNotFoundException {
		logger.info("Entered removeHotel()");
		List<Hotel> allHotel = hotelService.removeHotel(hotelId);
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}

	// Endpoint to fetch all the hotel details from database
	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> showAllHotels() throws HotelNotFoundException {
		logger.info("Entered showAllHotels()");
		List<Hotel> allHotel = hotelService.showAllHotels();
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}

	// Endpoint to fetch the hotel details by using hotelId from database
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> showHotel(@PathVariable("hotelId") int hotelId) throws HotelNotFoundException {
		logger.info("Entered showHotel()");
		Hotel hotel = hotelService.showHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}
	
	@PostMapping("/hotel/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserNotFoundException("User Forbidden");
		}
		String token = jwtTokenUtil.generateToken(jwtRequest);
		Hotel receivedHotel = hotelService.loginHotelJwt(jwtRequest);
		return new ResponseEntity<>(new JwtHotelResponse(token, receivedHotel), HttpStatus.OK);
	}
}
