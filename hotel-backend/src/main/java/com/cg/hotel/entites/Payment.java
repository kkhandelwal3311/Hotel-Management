package com.cg.hotel.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payments_seq")
	@SequenceGenerator(name = "payments_seq", sequenceName = "payments_seq", allocationSize = 1)
	@Column(name = "payment_id")
	private int paymentId;

	@OneToOne
	@JoinColumn(name = "booking_id")
	private BookingDetails bookingId;

	@OneToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transactionId;

	public Payment() {

	}

	public Payment(int paymentId, BookingDetails bookingId, Transaction transactionId) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.transactionId = transactionId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public BookingDetails getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingDetails bookingId) {
		this.bookingId = bookingId;
	}

	public Transaction getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Transaction transactionId) {
		this.transactionId = transactionId;
	}
}
