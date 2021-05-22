package com.cg.hotel.hotelservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hotel.entites.Hotel;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.repository.HotelRepository;
import com.cg.hotel.service.HotelService;

@SpringBootTest
class HotelTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private HotelService hotelService;

	@MockBean
	private HotelRepository hotelRepository;

	// Test for adding hotel
	@Test
	@DisplayName("Test for adding hotel")
	public void addHotelTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		assertEquals(hotel, hotelService.addHotel(hotel));
	}

	// Test for updating hotel
	@Test
	@DisplayName("Test for updating hotel")
	public void updateHotelTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		assertEquals(hotel, hotelService.updateHotel(hotel));
	}

	// Test for deleting hotel
	@Test
	@DisplayName("Test for deleting hotel")
	public void removeHotelTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		hotelService.removeHotel(1);
		verify(hotelRepository, times(1)).deleteById(1);
		;
	}

	// Test for displaying all hotels
	@Test
	@DisplayName("Test for displaying all hotels")
	public void showAllHotelsTest() {
		when(hotelRepository.findAll()).thenReturn(Stream.of(
				new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111", "kit.com",""),
				new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111", "kit.com",""))
				.collect(Collectors.toList()));
		assertEquals(2, hotelService.showAllHotels().size());
	}

	// Test for displaying one hotel
	@Test
	@DisplayName("Test for displaying one hotel")
	public void showHotelTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		when(hotelRepository.findById(1)).thenReturn(Optional.of(hotel));
		assertEquals(hotel, hotelService.showHotel(1));
	}

	// Exception test for displaying all hotels
	@Test
	@DisplayName("Test exception for displaying all hotels")
	public void showAllHotelsTestException() {
		List<Hotel> allHotel = new ArrayList<>();
		when(hotelRepository.findAll()).thenReturn(allHotel);
		Exception exception = assertThrows(HotelNotFoundException.class, () -> hotelService.showAllHotels());
		assertEquals("Hotels not found", exception.getMessage());
	}

	// Exception test for displaying single hotel by using hotelId
	@Test
	@DisplayName("Test exception for displaying one hotel")
	public void showHotelTestException() {
		when(hotelRepository.findById(1)).thenReturn(Optional.empty());

		Exception exception = assertThrows(HotelNotFoundException.class, () -> hotelService.showHotel(1));
		assertEquals("Hotel not found by hotel Id", exception.getMessage());
	}

}
