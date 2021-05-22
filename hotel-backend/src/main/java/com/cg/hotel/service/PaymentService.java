package com.cg.hotel.service;

import java.util.List;

import com.cg.hotel.entites.Payment;

public interface PaymentService {

	public Payment addPayment(Payment payment);

	List<Payment> showAllPayments();
	Payment showPaymentDetails(int paymentId);

}
