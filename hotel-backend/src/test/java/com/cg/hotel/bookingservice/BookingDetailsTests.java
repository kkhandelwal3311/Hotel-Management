package com.cg.hotel.bookingservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.Room;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.BookingDetailsNotFoundException;
import com.cg.hotel.repository.BookingDetailsRepository;
import com.cg.hotel.service.BookingDetailsService;

@SpringBootTest
class BookingDetailsTests {

	@Autowired
	BookingDetailsService bookingDetailsService;

	@MockBean
	BookingDetailsRepository bookingDetailsRepository;

	// Test for Adding Booking details
	@Test
	@DisplayName("Test for Adding booking details")
	public void addBookingDetailsTest() {
		// when - thenReturn
		Date boookedFrom = new Date();
		Date bookedTo = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		BookingDetails bookingDetails = new BookingDetails(1, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000);

		when(bookingDetailsRepository.save(bookingDetails)).thenReturn(bookingDetails);
		assertEquals(bookingDetails, bookingDetailsService.addBookingDetails(bookingDetails));
	}

	// Test for Update booking details
	@Test
	@DisplayName("Test for Update booking details")
	public void updateBookingDetailsTest() {
		// when - thenReturn
		Date boookedFrom = new Date();
		Date bookedTo = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		BookingDetails bookingDetails = new BookingDetails(1, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000);

		when(bookingDetailsRepository.save(bookingDetails)).thenReturn(bookingDetails);
		assertEquals(bookingDetails, bookingDetailsService.updateBookingDetails(bookingDetails));
	}

	// Test for deleting booking detail
	@Test
	@DisplayName("Test for deleting booking detail")
	public void removeBookingDetailsTest() {
		Date boookedFrom = new Date();
		Date bookedTo = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		BookingDetails bookingDetails = new BookingDetails(1, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000);

		bookingDetailsService.removeBookingDetails(1);
		verify(bookingDetailsRepository, times(1)).deleteById(1);

	}

	// Test for displaying all booking details
	@Test
	@DisplayName("Test for displaying all booking details")
	public void showAllBookingDetailsTest() {

		Date boookedFrom = new Date();
		Date bookedTo = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");

		when(bookingDetailsRepository.findAll()).thenReturn(Stream
				.of(new BookingDetails(1, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000),
						new BookingDetails(2, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000))
				.collect(Collectors.toList()));
		assertEquals(2, bookingDetailsService.showAllBookingDetails().size());
	}

	// Test for displaying one booking detail by Id
	@Test
	@DisplayName("Test for displaying one booking detail by Id")
	public void showBookingDetailsTest() {
		Date boookedFrom = new Date();
		Date bookedTo = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		BookingDetails bookingDetails = new BookingDetails(1, hotel, room, user, boookedFrom, bookedTo, 2, 0, 5000);

		when(bookingDetailsRepository.findById(1)).thenReturn(Optional.of(bookingDetails));
		assertEquals(bookingDetails, bookingDetailsService.showBookingDetails(1));
	}

	// Exception Test for displaying all bookings
	@Test
	@DisplayName("Test for displaying exception all booking")
	public void showAllBookingDetailsTestException() {
		List<BookingDetails> allBooking = new ArrayList<>();

		when(bookingDetailsRepository.findAll()).thenReturn(allBooking);

		Exception exception = assertThrows(BookingDetailsNotFoundException.class,
				() -> bookingDetailsService.showAllBookingDetails());
		assertEquals("Booking details not found", exception.getMessage());
	}

	// Exception Test for displaying single booking by bookingId
	@Test
	@DisplayName("Test for displaying exception one booking by id")
	public void showBookingDetailsTestException() {

		when(bookingDetailsRepository.findById(1)).thenReturn(Optional.empty());

		Exception exception = assertThrows(BookingDetailsNotFoundException.class,
				() -> bookingDetailsService.showBookingDetails(1));
		assertEquals("Booking details not found by bookingId", exception.getMessage());
	}

}
