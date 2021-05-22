package com.cg.hotel.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	@SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq", allocationSize = 1)
	@Column(name = "booking_id")
	private int bookingId;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotelId;

	@OneToOne
	@JoinColumn(name = "room_id")
	private Room roomId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "booked_from")
	@FutureOrPresent(message = "Booking Date should be after today")
	private Date bookedFrom;

	@Column(name = "booked_to")
	@Future(message = "Checkout Date should be after today")
	private Date bookedTo;

	@Column(name = "no_of_adults")
	@Min(value = 1, message = "There should be atleast one Adult")
	private int noOfAdults;

	@Column(name = "no_of_childern")
	@Min(value = 0, message = "There should be less than one child")
	private int noOfChildren;

	@Column(name = "amount")
	@Min(value = 0, message = "Amount should not be less than 0")
	private double amount;

	public BookingDetails() {

	}

	public BookingDetails(int bookingId, Hotel hotelId, Room roomId, User userId, Date bookedFrom, Date bookedTo,
			int noOfAdults, int noOfChildren, double amount) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Hotel getHotelId() {
		return hotelId;
	}

	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", hotelId=" + hotelId + ", roomId=" + roomId + ", userId="
				+ userId + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + ", noOfAdults=" + noOfAdults
				+ ", noOfChildren=" + noOfChildren + ", amount=" + amount + "]";
	}
}
