package com.cg.hotel.roomservice;

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
import com.cg.hotel.entites.Room;
import com.cg.hotel.exception.RoomNotFoundException;
import com.cg.hotel.repository.RoomRepository;
import com.cg.hotel.service.RoomService;

@SpringBootTest
class RoomTests {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Autowired
	RoomService roomService;

	@MockBean
	RoomRepository roomRepository;

	// Test for adding room
	@Test
	@DisplayName("Test for adding room")
	public void addRoomTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		when(roomRepository.save(room)).thenReturn(room);
		assertEquals(room, roomService.addRoom(room));
	}

	// Test for updating room
	@Test
	@DisplayName("Test for updating room")
	public void updateRoomTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		when(roomRepository.save(room)).thenReturn(room);
		assertEquals(room, roomService.updateRoom(room));
	}

	// Test for deleting room
	@Test
	@DisplayName("Test for deleting room")
	public void removeRoom() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		roomService.removeRoom(100);
		verify(roomRepository, times(1)).deleteById(100);
	}

	// Test for displaying all rooms
	@Test
	@DisplayName("Test for displaying all rooms")
	public void showAllRoomTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		when(roomRepository.findAll()).thenReturn(Stream
				.of(new Room(1, hotel, "100", "Delux", 1000, "Y"), new Room(2, hotel, "101", "SuperDelux", 5000, "Y"))
				.collect(Collectors.toList()));
		assertEquals(2, roomService.showAllRoom().size());
	}

	// Test for displaying one room by Id
	@Test
	@DisplayName("Test for displaying one room by Id")
	public void showRoomTest() {
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111",
				"kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		when(roomRepository.findById(1)).thenReturn(Optional.of(room));
		assertEquals(room, roomService.showRoom(1));
	}
	
	// Exception Test for displaying all room
	@Test
	@DisplayName("Test for displaying exception all room")
	public void showAllRoomTestException() {
		List<Room> allRoom= new ArrayList<>();
		
		when(roomRepository.findAll())
				.thenReturn(allRoom);
		
		Exception exception = assertThrows(RoomNotFoundException.class, () -> roomService.showAllRoom());
		assertEquals("No Rooms found", exception.getMessage());
	}
	
	// Exception Test for displaying one room by using roomId
	@Test
	@DisplayName("Test for displaying exception one room by id")
	public void showRoomTestException() {
		
		when(roomRepository.findById(1)).thenReturn(Optional.empty());
		
		Exception exception = assertThrows(RoomNotFoundException.class, () -> roomService.showRoom(1));
		assertEquals("No Room found", exception.getMessage());
	}


}
