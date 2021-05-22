package com.cg.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.service.BookingDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookingDetailsController {

	@Autowired
	BookingDetailsService bookingDetailsService;

	Logger logger = LoggerFactory.getLogger(BookingDetailsController.class);

	// Endpoint to create or add new booking details
	@PostMapping("/booking")
	public BookingDetails addBookingDetails(@Valid @RequestBody BookingDetails bookingDetails) {
		logger.info("Entered addBookingDetails()");
		return bookingDetailsService.addBookingDetails(bookingDetails);
	};

	// Endpoint to update existing booking details
	@PutMapping("/booking")
	public BookingDetails updateBookingDetails(@RequestBody BookingDetails bookingDetails) {
		logger.info("Entered updateBookingDetails()");
		return bookingDetailsService.updateBookingDetails(bookingDetails);
	}

	// Endpoint to delete existing booking details by using bookingId
	@DeleteMapping("/booking/{bookingId}")
	public ResponseEntity<List<BookingDetails>> removeBookingDetails(@PathVariable("bookingId") int bookingId) {
		logger.info("Entered removeBookingDetails()");
		List<BookingDetails> allBookings = bookingDetailsService.removeBookingDetails(bookingId);
		return new ResponseEntity<List<BookingDetails>>(allBookings, HttpStatus.OK);
	}

	// Endpoint to fetch all the booking details from database
	@GetMapping("/booking")
	public List<BookingDetails> showAllBookingDetails() {
		logger.info("Entered showAllBookingDetails()");
		List<BookingDetails> allBookingDetails = bookingDetailsService.showAllBookingDetails();
		return allBookingDetails;
	}

	// Endpoint to fetch the booking details by using bookingId from database
	@GetMapping("/booking/{bookingId}")
	public BookingDetails showBookingDetails(@PathVariable("bookingId") int bookingId) {
		logger.info("Entered showBookingDetails()");
		return bookingDetailsService.showBookingDetails(bookingId);
	}
}
