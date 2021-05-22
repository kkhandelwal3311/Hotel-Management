package com.cg.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.entites.BookingDetails;
import com.cg.hotel.entites.Payment;
import com.cg.hotel.service.PaymentService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class PaymentController {

	@Autowired
	PaymentService paymentService;

	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	// Endpoint to add or make new payments
	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		logger.info("Entered addPayment()");
		return paymentService.addPayment(payment);
	}

	// Endpoint to fetch all the Payment from database
	@GetMapping("/payment")
	public List<Payment> showAllPayment() {
		logger.info("Entered showAllPayment()");
		List<Payment> allPayment = paymentService.showAllPayments();
		return allPayment;
	}
	
	@GetMapping("/payment/{paymentId}")
	public Payment showPaymentDetails(@PathVariable("paymentId") int paymentId) {
		logger.info("Entered showPaymentDetails()");
		return paymentService.showPaymentDetails(paymentId);
	}
	

}
