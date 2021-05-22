package com.cg.hotel.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.Payment;
import com.cg.hotel.entites.Room;
import com.cg.hotel.exception.BookingDetailsNotFoundException;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.exception.RoomNotFoundException;
import com.cg.hotel.repository.BookingDetailsRepository;
import com.cg.hotel.repository.HotelRepository;
import com.cg.hotel.repository.PaymentRepository;
import com.cg.hotel.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	BookingDetailsRepository bookingRepository;

	@Autowired
	PaymentRepository paymentRepository;

	Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	// method to add new room
	@Override
	public Room addRoom(Room room) {
		logger.info("Entered service addRoom()");
		return roomRepository.save(room);
	}

	// method to update existing room
	@Override
	public Room updateRoom(Room room) {
		logger.info("Entered service updateRoom()");
		return roomRepository.save(room);
	}

	// method to delete room by using roomId
	@Override
	public List<Room> removeRoom(int roomId) {
		logger.info("Entered service removeRoom()");
		try {
			roomRepository.deleteById(roomId);
		} catch (Exception e) {
			throw new RoomNotFoundException("No Room found by Id");
		}
		return roomRepository.findAll();
	}

	// method to fetch all the rooms from database
	@Override
	public List<Room> showAllRoom() {
		logger.info("Entered service showAllRoom()");
		List<Room> allRoom = roomRepository.findAll();
		if (allRoom.isEmpty()) {
			throw new RoomNotFoundException("No Rooms found");
		}
		return allRoom;
	}

	// method to show single room by using roomId
	@Override
	public Room showRoom(int roomId) {
		logger.info("Entered service showRoom()");
		Optional<Room> temporaryRoomDetails = roomRepository.findById(roomId);
		if (temporaryRoomDetails.isPresent()) {
			return temporaryRoomDetails.get();
		} else {
			throw new RoomNotFoundException("No Room found");
		}
	}

	// method to show all the room which are mapped under hotel by using hotelId
	@Override
	public List<Room> showHotelRoom(int hotelId) {
		logger.info("Entered service showHotelRoom()");
		List<Room> allRoom = roomRepository.findAll();

		allRoom = allRoom.stream().filter((a) -> a.getHotelId().getHotelId() == hotelId).collect(Collectors.toList());

		if (allRoom.isEmpty()) {
			throw new RoomNotFoundException("No Rooms found in this hotel");
		}
		return allRoom;
	}

	// method to show all the room which are available on the date entered by user
	@Override
	public List<Room> showAvailableHotelRoom(int hotelId, Date bookedFrom, Date bookedTo) {
		logger.info("Entered service showAvailableHotelRoom()");
		List<Room> allRoom = roomRepository.findAll();
		List<BookingDetails> allBooking = bookingRepository.findAll();

		allRoom = allRoom.stream().filter((a) -> a.getHotelId().getHotelId() == hotelId).collect(Collectors.toList());

		if (allBooking.isEmpty()) {
			throw new BookingDetailsNotFoundException("No bookings available");
		}
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String bookedFromDate = simpleDateFormat.format(bookedFrom);
		String bookedToDate = simpleDateFormat.format(bookedTo);
		System.out.println(bookedFromDate);
		System.out.println(bookedToDate);

		for (int i = 0; i < allRoom.size(); i++) {
			for (int j = 0; j < allBooking.size(); j++) {
				if (allRoom.get(i).getRoomId() == allBooking.get(j).getRoomId().getRoomId()) {
					Date bookedFromCheck = allBooking.get(j).getBookedFrom();
					Date bookedToCheck = allBooking.get(j).getBookedTo();

					String bookedFromDateCheck = simpleDateFormat.format(bookedFromCheck);
					String bookedToDateCheck = simpleDateFormat.format(bookedToCheck);
					System.out.println(bookedFromDateCheck);
					System.out.println(bookedToDateCheck);

					if ((bookedFromDate.compareTo(bookedFromDateCheck) >= 0
							&& bookedToDate.compareTo(bookedToDateCheck) <= 0)
							|| (bookedFromDate.compareTo(bookedFromDateCheck) <= 0
									&& bookedToDate.compareTo(bookedToDateCheck) >= 0)
							|| (bookedFromDate.compareTo(bookedToDateCheck) >= 0
									&& bookedToDate.compareTo(bookedFromDateCheck) <= 0)
							|| (bookedFromDate.compareTo(bookedToDateCheck) <= 0
									&& bookedToDate.compareTo(bookedFromDateCheck) >= 0)) {
						allRoom.remove(i);
					}
				}
			}
		}

		if (allRoom.isEmpty()) {
			throw new RoomNotFoundException("No Rooms available in this hotel");
		}
		return allRoom;
	}

	@Override
	public List<BookingDetails> showBookedRoom(int hotelId) {
		// TODO Auto-generated method stub
		List<Room> allRoom = roomRepository.findAll();
		List<BookingDetails> allBooking = bookingRepository.findAll();
		List<BookingDetails> bookedDetails = new ArrayList<>();

		allRoom = allRoom.stream().filter((a) -> a.getHotelId().getHotelId() == hotelId).collect(Collectors.toList());

		if (allBooking.isEmpty()) {
			throw new BookingDetailsNotFoundException("No bookings available");
		}

		for (int i = 0; i < allRoom.size(); i++) {
			for (int j = 0; j < allBooking.size(); j++) {
				if (allRoom.get(i).getRoomId() == allBooking.get(j).getRoomId().getRoomId()) {
					bookedDetails.add(allBooking.get(j));
				}
			}
		}

		return bookedDetails;
	}

	public List<Payment> showHotelPayment(@PathVariable("hotelId") int hotelId) {
		List<Payment> allPayment = paymentRepository.findAll();
		Optional<Hotel> temporaryHotel = hotelRepository.findById(hotelId);
		List<Payment> paymentDetails = new ArrayList<>();
		Hotel hotel = new Hotel();
		if (temporaryHotel.isPresent()) {
			hotel = temporaryHotel.get();
		} else {
			throw new HotelNotFoundException("No Room found");
		}
		for (int i = 0; i < allPayment.size(); i++) {
			if(allPayment.get(i).getBookingId().getHotelId().getHotelId() == hotel.getHotelId()) {
				paymentDetails.add(allPayment.get(i));
			}
		}
		return paymentDetails;
	}

}
