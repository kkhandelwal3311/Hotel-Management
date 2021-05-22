package com.cg.hotel.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	// method to add new hotel
	@Override
	public Hotel addHotel(Hotel hotel) {
		logger.info("Entered service addHotel()");
		return hotelRepository.save(hotel);
	}

	// method to update existing hotel
	@Override
	public Hotel updateHotel(Hotel hotel) {
		logger.info("Entered service updateHotel()");
		return hotelRepository.save(hotel);
	}

	// method to delete existing hotel using hotelId
	@Override
	public List<Hotel> removeHotel(int hotelId) {
		logger.info("Entered service removeHotel()");
		try {
			hotelRepository.deleteById(hotelId);
		} catch (EmptyResultDataAccessException e) {
			throw new HotelNotFoundException("Hotel not found by hotel Id");
		}
		return hotelRepository.findAll();
	}

	// method to fetch all the hotels from database
	@Override
	public List<Hotel> showAllHotels() {
		logger.info("Entered service showAllHotels()");
		List<Hotel> allHotel = hotelRepository.findAll();
		if (allHotel.isEmpty()) {
			throw new HotelNotFoundException("Hotels not found");
		}
		return hotelRepository.findAll();
	}

	// method to fetch hotel by using hotelId
	@Override
	public Hotel showHotel(int hotelId) {
		logger.info("Entered service showHotel()");
		Optional<Hotel> temporaryHotel = hotelRepository.findById(hotelId);
		if (temporaryHotel.isPresent()) {
			return temporaryHotel.get();
		} else {
			throw new HotelNotFoundException("Hotel not found by hotel Id");
		}
	}

	@Override
	public Hotel loginHotelJwt(JwtRequest jwtRequest) {
		// TODO Auto-generated method stub
		List<Hotel> allHotel = hotelRepository.findAll();

		for (Hotel oneHotel : allHotel) {
			if (jwtRequest.getEmail().toLowerCase().equals(oneHotel.getEmail().toLowerCase())) {
				if (jwtRequest.getPassword().equals(oneHotel.getPassword())) {
					return oneHotel;
				}
				throw new HotelNotFoundException("Please check password");
			}
		}
		throw new HotelNotFoundException("Hotel not found please check email password");
	}
		

}
