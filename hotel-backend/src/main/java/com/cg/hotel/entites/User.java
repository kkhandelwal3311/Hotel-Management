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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	@NotBlank(message = "Name is mandatory")
	private String userName;

	@Column(name = "email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@Column(name = "password")
	@NotBlank(message = "password is mandatory")
	@Size(min = 8, max = 200, message = "password should be atleast 8 characters long")
	private String password;

	@Column(name = "role")                                
	private String role;                                 // student, Service, Business

	@Column(name = "mobile")
	@Size(min = 10, max = 13, message = "mobile number should be valid")
	@NotBlank(message = "mobile number is mandatory")
	private String mobile;

	@Column(name = "address")
	@NotBlank(message = "address is mandatory")
	private String address;

	// OneToMany - Booking_details
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	private Set<BookingDetails> userBookingDetails = new HashSet<>();

	public User() {

	}

	public User(int userId, String userName, String email, String password, String role, String mobile,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
