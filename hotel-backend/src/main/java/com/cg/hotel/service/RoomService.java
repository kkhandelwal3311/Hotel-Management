package com.cg.hotel.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Payment;
import com.cg.hotel.entites.Room;

public interface RoomService {
	public Room addRoom(Room room);
	public Room updateRoom(Room room);
	public List<Room> removeRoom(int roomId);
	public List<Room> showAllRoom();
	public Room showRoom(int roomId);
	public List<Room> showHotelRoom(int hotelId);
        List<Room> showAvailableHotelRoom(int hotelId, Date bookedFrom, Date bookedTo);
	public List<BookingDetails> showBookedRoom(int hotelId);
	public List<Payment> showHotelPayment(int hotelId);
}
