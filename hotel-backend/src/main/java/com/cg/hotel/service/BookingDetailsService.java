package com.cg.hotel.service;

import java.util.List;

import com.cg.hotel.entites.BookingDetails;

public interface BookingDetailsService {

	public BookingDetails addBookingDetails(BookingDetails bookingDetails);

	public BookingDetails updateBookingDetails(BookingDetails bookingDetails);

	public List<BookingDetails> removeBookingDetails(int bookingId);

	public List<BookingDetails> showAllBookingDetails();

	public BookingDetails showBookingDetails(int bookingId);

}
