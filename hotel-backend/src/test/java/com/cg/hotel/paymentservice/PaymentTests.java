
package com.cg.hotel.paymentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Hotel;
import com.cg.hotel.entites.Payment;
import com.cg.hotel.entites.Room;
import com.cg.hotel.entites.Transaction;
import com.cg.hotel.entites.User;
import com.cg.hotel.exception.PaymentNotFoundException;
import com.cg.hotel.repository.PaymentRepository;
import com.cg.hotel.service.PaymentService;

@SpringBootTest
public class PaymentTests {
	
//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private PaymentService paymentService;
	
	@MockBean
	private PaymentRepository paymentRepository;
	
	// Test for adding payments
	@Test
	@DisplayName("Test for adding payments")
	public void addPaymentTest() {
		Date d = new Date();
		Date d2 = new Date();
		Hotel hotel = new Hotel(1, "pune", "kitkat hotel", "chinch", "desc", 2000, "abc@gmail", "00000", "11111", "kit.com","");
		Room room = new Room(100, hotel, "100", "Delux", 1000, "Y");
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		BookingDetails bookingDetails = new BookingDetails(1, hotel, room, user, d, d2, 2, 0 , 5000);
		Transaction transaction = new Transaction(12345678 , 5000.00);
		Payment payment = new Payment(23456789 , bookingDetails , transaction);
		when(paymentRepository.save(payment)).thenReturn(payment);
		assertEquals(payment, paymentService.addPayment(payment));
	}
	
	// Test for displaying exception all payments
	@Test
	@DisplayName("Test for displaying exception all payments")
	public void showAllUsersTestException() {
		List<Payment> allPayment = new ArrayList<>();
		
		when(paymentRepository.findAll())
				.thenReturn(allPayment);
		
		Exception exception = assertThrows(PaymentNotFoundException.class, () -> paymentService.showAllPayments());
		assertEquals("Payments not found", exception.getMessage());
	}

}


