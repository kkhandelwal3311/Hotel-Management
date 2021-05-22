package com.cg.hotel.controller;

import java.util.Date;
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
import com.cg.hotel.entites.Payment;
import com.cg.hotel.entites.Room;
import com.cg.hotel.service.RoomService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoomController {

	@Autowired
	RoomService roomService;

	Logger logger = LoggerFactory.getLogger(RoomController.class);

	// Endpoint to add new room in a hotel
	@PostMapping("/room")
	public Room addRoom(@Valid @RequestBody Room room) {
		logger.info("Entered addRoom()");
		return roomService.addRoom(room);
	}

	// Endpoint to update existing room in a hotel
	@PutMapping("/room")
	public Room updateRoom(@Valid @RequestBody Room room) {
		logger.info("Entered updateRoom()");
		return roomService.updateRoom(room);
	}

	// Endpoint to delete room by using roomId
	@DeleteMapping("/room/{roomId}")
	public ResponseEntity<List<Room>> removeRoom(@PathVariable("roomId") int roomId) {
		logger.info("Entered removeRoom()");
		List<Room> allRoom = roomService.removeRoom(roomId);
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}

	// Endpoint to fetch all the rooms present in database
	@GetMapping("/room")
	public ResponseEntity<List<Room>> showAllRoom() {
		logger.info("Entered showAllRoom()");
		List<Room> allRoom = roomService.showAllRoom();
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}

	// Endpoint to fetch a room by using roomId from database
	@GetMapping("/room/{roomId}")
	public ResponseEntity<Room> showRoom(@PathVariable("roomId") int roomId) {
		logger.info("Entered showRoom()");
		Room room = roomService.showRoom(roomId);
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}

	// Endpoint to fetch all the rooms present for the hotel using hotelId
	@GetMapping("/room/hotel/{hotelId}")
	public ResponseEntity<List<Room>> showHotelRoom(@PathVariable("hotelId") int hotelId) {
		logger.info("Entered showHotelRoom()");
		List<Room> allRoom = roomService.showHotelRoom(hotelId);
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}

	// Endpoint to fetch all the Available rooms present for the hotel using hotelId
	@PostMapping("/room/availablehotel/{hotelId}")
	public ResponseEntity<List<Room>> showAvailableHotelRoom(@PathVariable("hotelId") int hotelId,
			@RequestBody BookingDetails bookingDetails) {
		logger.info("Entered showAvailableHotelRoom()");
		Date bookedFrom = bookingDetails.getBookedFrom();
		Date bookedTo = bookingDetails.getBookedTo();

		List<Room> allRoom = roomService.showAvailableHotelRoom(hotelId, bookedFrom, bookedTo);
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}
	
	@GetMapping("/room/bookedroom/{hotelId}")
	public ResponseEntity<List<BookingDetails>> showBookedRoom(@PathVariable("hotelId") int hotelId){
		List<BookingDetails> bookingDetails = roomService.showBookedRoom(hotelId);
		return new ResponseEntity<List<BookingDetails>>(bookingDetails, HttpStatus.OK);
	}
	
	@GetMapping("/room/payment/{hotelId}")
	public ResponseEntity<List<Payment>> showHotelPayment(@PathVariable("hotelId") int hotelId){
		List<Payment> paymentDetails = roomService.showHotelPayment(hotelId);
		return new ResponseEntity<List<Payment>>(paymentDetails, HttpStatus.OK);
	}
}
