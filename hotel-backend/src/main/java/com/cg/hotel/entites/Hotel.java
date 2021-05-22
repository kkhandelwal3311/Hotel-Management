package com.cg.hotel.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel_seq")
	@SequenceGenerator(name = "hotel_seq", sequenceName = "hotel_seq", allocationSize = 1)
	@Column(name = "hotel_id")
	private int hotelId;

	@Column(name = "city")
	@NotBlank(message = "hotel city is mandatory")
	private String city;

	@Column(name = "hotel_name")
	@NotBlank(message = "Hotel name is mandatory")
	private String hotelName;

	@Column(name = "address")
	@NotBlank(message = "Hotel address is mandatory")
	private String address;

	@Column(name = "description")
	@NotBlank(message = "Hotel description is mandatory")
	private String description;

	@Column(name = "avg_rate_per_day")
	@Min(value = 0, message = "Rate should not be less than 0")
	private double avgRatePerDay;

	@Column(name = "email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	
	@Column(name = "password")
	@NotBlank(message = "password is mandatory")
	@Size(min = 5, max = 200, message = "password should be atleast 5 characters long")
	private String password;

	@Column(name = "phone1")
	@Size(min = 10, max = 13, message = "mobile number should be valid")
	@NotBlank(message = "mobile number is mandatory")
	private String phone1;

	@Column(name = "phone2")
	private String phone2;

	@Column(name = "website")
	@NotBlank(message = "website is mandatory")
	private String website;

	// OneToMany - Room
	@OneToMany(mappedBy = "hotelId", cascade = CascadeType.ALL)
	private Set<Room> hotelRooms = new HashSet<>();

	// OneToMany - Booking details
	@OneToMany(mappedBy = "hotelId", cascade = CascadeType.ALL)
	private Set<BookingDetails> hotelBookingDetails = new HashSet<>();

	public Hotel() {

	}

	public Hotel(int hotelId, String city, String hotelName, String address, String description, double avgRatePerDay,
			String email, String phone1, String phone2, String website, String password) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.password = password;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgRatePerDay() {
		return avgRatePerDay;
	}

	public void setAvgRatePerDay(double avgRatePerDay) {
		this.avgRatePerDay = avgRatePerDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", city=" + city + ", hotelName=" + hotelName + ", address=" + address
				+ ", description=" + description + ", avgRatePerDay=" + avgRatePerDay + ", email=" + email + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", website=" + website + ", hotelRooms=" + hotelRooms
				+ ", hotelBookingDetails=" + hotelBookingDetails + "]";
	}
}
