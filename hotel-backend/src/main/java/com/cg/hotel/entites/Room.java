package com.cg.hotel.entites;

import javax.persistence.Column;

//import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "room_details")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq ")
	@SequenceGenerator(name = "room_seq ", sequenceName = "room_seq ", allocationSize = 1)
	@Column(name = "room_id")
	private int roomId;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotelId;

	@Column(name = "room_no")
	@NotBlank(message = "Room number is mandatory")
	private String roomNo;

	@Column(name = "room_type")
	@NotBlank(message = "Room type is mandatory")
	private String roomType;

	@Column(name = "rate_per_day")
	@Min(value = 0, message = "Rate should not be less than 0")
	private double ratePerDay;

	@Column(name = "is_available")
	@NotBlank(message = "Available status is mandatory")
	private String isAvailable;

	public Room() {

	}

	public Room(int roomId, Hotel hotelId, String roomNo, String roomType, double ratePerDay, String isAvailable) {
		super();
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.isAvailable = isAvailable;
	}

	public Hotel getHotelId() {
		return hotelId;
	}

	public void setHotelId(Hotel hotelId) {
		this.hotelId = hotelId;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	@Override
	public String toString() {
		return "RoomDetails [roomId=" + roomId + ", hotelId=" + hotelId + ", roomNo=" + roomNo + ", roomType="
				+ roomType + ", ratePerDay=" + ratePerDay + ", isAvailable=" + isAvailable + "]";
	}
}
