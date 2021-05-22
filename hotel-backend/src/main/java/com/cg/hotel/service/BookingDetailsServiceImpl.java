package com.cg.hotel.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.exception.BookingDetailsNotFoundException;
import com.cg.hotel.repository.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	BookingDetailsRepository bookingRepository;

	Logger logger = LoggerFactory.getLogger(BookingDetailsServiceImpl.class);

	// method to add bookings
	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		logger.info("Entered service addBookingDetails()");
		return bookingRepository.save(bookingDetails);
	}

	// method to update bookings
	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
		// TODO Auto-generated method stub
		logger.info("Entered service updateBookingDetails()");
		return bookingRepository.save(bookingDetails);
	}

	// method to delete bookings using bookingId
	@Override
	public List<BookingDetails> removeBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		logger.info("Entered service removeBookingDetails()");
		try {
			bookingRepository.deleteById(bookingId);
		} catch (Exception e) {
			throw new BookingDetailsNotFoundException("Booking details not found");
		}
		return bookingRepository.findAll();
	}

	// method to show all bookings from database
	@Override
	public List<BookingDetails> showAllBookingDetails() {
		// TODO Auto-generated method stub
		logger.info("Entered service showAllBookingDetails()");
		List<BookingDetails> allBookings = bookingRepository.findAll();
		if (allBookings.isEmpty()) {
			throw new BookingDetailsNotFoundException("Booking details not found");
		}
		return allBookings;
	}

	// method to fetch booking details using bookingId
	@Override
	public BookingDetails showBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		logger.info("Entered service showBookingDetails()");
		Optional<BookingDetails> temporaryBookingDetails = bookingRepository.findById(bookingId);
		if (temporaryBookingDetails.isPresent()) {
			return temporaryBookingDetails.get();
		} else {
			throw new BookingDetailsNotFoundException("Booking details not found by bookingId");
		}

	}

}
