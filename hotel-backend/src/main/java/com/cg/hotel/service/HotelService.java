package com.cg.hotel.service;

import java.util.List;

import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtRequest;

public interface HotelService {
	public Hotel addHotel(Hotel hotel);

	public Hotel updateHotel(Hotel hotel);

	public List<Hotel> removeHotel(int hotelId);

	public List<Hotel> showAllHotels();

	public Hotel showHotel(int hotelId);

	public Hotel loginHotelJwt(JwtRequest jwtRequest);

}
