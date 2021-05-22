package com.cg.hotel.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.Payment;
import com.cg.hotel.exception.BookingDetailsNotFoundException;
import com.cg.hotel.exception.PaymentNotFoundException;
import com.cg.hotel.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

	// method to add new payment
	@Override
	public Payment addPayment(Payment payment) {
		logger.info("Entered service addPayment()");
		return paymentRepository.save(payment);
	}

	// method to fetch all payments
	@Override
	public List<Payment> showAllPayments() {
		logger.info("Entered service showAllPayments()");
		List<Payment> allPayments = paymentRepository.findAll();
		if (allPayments.isEmpty()) {
			throw new PaymentNotFoundException("Payments not found");
		}
		return allPayments;
	}

	@Override
	public Payment showPaymentDetails(int paymentId) {
		// TODO Auto-generated method stub
		logger.info("Entered service showAllPayments()");
		Optional<Payment> temporaryPayment = paymentRepository.findById(paymentId);
		if (temporaryPayment.isPresent()) {
			return temporaryPayment.get();
		} else {
			throw new PaymentNotFoundException("Payments not found by paymentId");
		}
	}

}
