package com.cg.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.config.JwtTokenUtil;
import com.cg.hotel.entites.Admin;
import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.JwtAdminResponse;
import com.cg.hotel.entites.JwtHotelResponse;
import com.cg.hotel.entites.JwtRequest;
import com.cg.hotel.entites.Payment;
import com.cg.hotel.entites.Room;
import com.cg.hotel.entites.Transaction;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.HotelNotFoundException;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.service.AdminService;
import com.cg.hotel.service.BookingDetailsService;
import com.cg.hotel.service.HotelService;
import com.cg.hotel.service.PaymentService;
import com.cg.hotel.service.RoomService;
import com.cg.hotel.service.TransactionService;
import com.cg.hotel.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	@Autowired
	HotelService hotelService;

	@Autowired
	RoomService roomService;

	@Autowired
	BookingDetailsService bookingDetailsService;

	@Autowired
	PaymentService paymentService;

	@Autowired
	TransactionService transactionService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/admin/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
		} catch (Exception ex) {
			throw new UserNotFoundException("User Forbidden");
		}
		String token = jwtTokenUtil.generateToken(jwtRequest);
		Admin receivedAdmin = adminService.loginAdminJwt(jwtRequest);
		return new ResponseEntity<>(new JwtAdminResponse(token, receivedAdmin), HttpStatus.OK);
	}
	
	// Endpoint - Admin SignIn
	@PostMapping("/admin/signin")
	public Admin signIn(@RequestBody Admin admin) {
		logger.info("Entered Admin signIn()");
		return adminService.signIn(admin);
	};

	// Endpoint - Admin SignOut
	@PostMapping("/admin/signout")
	public Admin signOut(@RequestBody Admin admin) {
		logger.info("Entered Admin signOut()");
		return adminService.signOut(admin);
	}

	// Endpoint to create or add new User

	@PostMapping("/admin/user")
	public User addUser(@Valid @RequestBody User user) {
		logger.info("Entered addUser()");
		return userService.addUser(user);
	}

	// Endpoint to update existing user

	@PutMapping("/admin/user")
	public User updateUser(@RequestBody User user) {
		logger.info("Entered updateUser()");
		return userService.updateUser(user);
	}

	// Endpoint to delete existing user by using userId

	@DeleteMapping("/admin/user/{userId}")
	public ResponseEntity<List<User>> removeUser(@PathVariable("userId") int userId) {
		logger.info("Entered removeUser()");
		List<User> allUser = userService.removeUser(userId);
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

	// Endpoint to fetch all users present in database

	@GetMapping("/admin/user")
	public ResponseEntity<List<User>> showAllUsers() {
		logger.info("Entered showAllUsers()");
		List<User> allUser = userService.showAllUsers();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

	// Endpoint to fetch user by using userId present in database

	@GetMapping("/admin/user/{userId}")
	public ResponseEntity<User> showUser(@PathVariable("userId") int userId) {
		logger.info("Entered showUser()");
		User user = userService.showUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Endpoint to add new Hotel details

	@PostMapping("/admin/hotel")
	public Hotel addHotel(@Valid @RequestBody Hotel hotel) {
		logger.info("Entered addHotel()");
		return hotelService.addHotel(hotel);
	}

	// Endpoint to update existing Hotel details

	@PutMapping("/admin/hotel")
	public Hotel updateHotel(@RequestBody Hotel hotel) {
		logger.info("Entered updateHotel()");
		return hotelService.updateHotel(hotel);
	}

	// Endpoint to delete existing Hotel details by using hotelId

	@DeleteMapping("/admin/hotel/{hotelId}")
	public ResponseEntity<List<Hotel>> removeHotel(@PathVariable("hotelId") int hotelId) throws HotelNotFoundException {
		logger.info("Entered removeHotel()");
		List<Hotel> allHotel = hotelService.removeHotel(hotelId);
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}

	// Endpoint to fetch all the hotel details from database

	@GetMapping("/admin/hotel")
	public ResponseEntity<List<Hotel>> showAllHotels() throws HotelNotFoundException {
		logger.info("Entered showAllHotels()");
		List<Hotel> allHotel = hotelService.showAllHotels();
		return new ResponseEntity<List<Hotel>>(allHotel, HttpStatus.OK);
	}

	// Endpoint to fetch the hotel details by using hotelId from database

	@GetMapping("/admin/hotel/{hotelId}")
	public ResponseEntity<Hotel> showHotel(@PathVariable("hotelId") int hotelId) throws HotelNotFoundException {
		logger.info("Entered showHotel()");
		Hotel hotel = hotelService.showHotel(hotelId);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
	}

	@PostMapping("/admin/room")
	public Room addRoom(@Valid @RequestBody Room room) {
		logger.info("Entered addRoom()");
		return roomService.addRoom(room);
	}

	@PutMapping("/admin/room")
	public Room updateRoom(@Valid @RequestBody Room room) {
		logger.info("Entered updateRoom()");
		return roomService.updateRoom(room);
	}

	@DeleteMapping("/admin/room/{roomId}")
	public ResponseEntity<List<Room>> removeRoom(@PathVariable("roomId") int roomId) {
		logger.info("Entered removeRoom()");
		List<Room> allRoom = roomService.removeRoom(roomId);
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}

	@GetMapping("/admin/room")
	public ResponseEntity<List<Room>> showAllRoom() {
		logger.info("Entered showAllRoom()");
		List<Room> allRoom = roomService.showAllRoom();
		return new ResponseEntity<List<Room>>(allRoom, HttpStatus.OK);
	}

	@GetMapping("/admin/room/{roomId}")
	public ResponseEntity<Room> showRoom(@PathVariable("roomId") int roomId) {
		logger.info("Entered showRoom()");
		Room room = roomService.showRoom(roomId);
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
	// Endpoint to create or add new booking details

	@PostMapping("/admin/booking")
	public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails) {
		logger.info("Entered addBookingDetails()");
		return bookingDetailsService.addBookingDetails(bookingDetails);
	};

	// Endpoint to update existing booking details

	@PutMapping("/admin/booking")
	public BookingDetails updateBookingDetails(@RequestBody BookingDetails bookingDetails) {
		logger.info("Entered updateBookingDetails()");
		return bookingDetailsService.updateBookingDetails(bookingDetails);
	}

	// Endpoint to delete existing booking details by using bookingId

	@DeleteMapping("/admin/booking/{bookingId}")
	public ResponseEntity<List<BookingDetails>> removeBookingDetails(@PathVariable("bookingId") int bookingId) {
		logger.info("Entered removeBookingDetails()");
		List<BookingDetails> allBookings = bookingDetailsService.removeBookingDetails(bookingId);
		return new ResponseEntity<List<BookingDetails>>(allBookings, HttpStatus.OK);
	}

	// Endpoint to fetch all the booking details from database

	@GetMapping("/admin/booking")
	public List<BookingDetails> showAllBookingDetails() {
		logger.info("Entered showAllBookingDetails()");
		List<BookingDetails> allBookingDetails = bookingDetailsService.showAllBookingDetails();
		return allBookingDetails;
	}

	// Endpoint to fetch the booking details by using bookingId from database

	@GetMapping("/admin/booking/{bookingId}")
	public BookingDetails showBookingDetails(@PathVariable("bookingId") int bookingId) {
		logger.info("Entered showBookingDetails()");
		return bookingDetailsService.showBookingDetails(bookingId);
	}

	// Endpoint to fetch all the Payment from database

	@GetMapping("/admin/payment")
	public List<Payment> showAllPayment() {
		logger.info("Entered showAllPayment()");
		List<Payment> allPayment = paymentService.showAllPayments();
		return allPayment;
	}

	// Endpoint to fetch all the Payment from database

	@GetMapping("/admin/transaction")
	public List<Transaction> showAllTransaction() {
		logger.info("Entered showAllTransaction()");
		List<Transaction> allTransaction = transactionService.showAllTransaction();
		return allTransaction;
	}

}
