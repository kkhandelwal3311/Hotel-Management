package com.cg.hotel.userservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hotel.entites.User;
import com.cg.hotel.exception.UserNotFoundException;
import com.cg.hotel.repository.UserRepository;
import com.cg.hotel.service.UserService;

@SpringBootTest
class UserTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	// Test for adding user
	@Test
	@DisplayName("Test for adding user")
	public void addUserTest() {
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}

	// Test for updating user
	@Test
	@DisplayName("Test for updating user")
	public void updateUserTest() {
		User user = new User(1, "sa", "email", "password", "job", "202020", "pune");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.updateUser(user));
	}

	// Test for deleting user
	@Test
	@DisplayName("Test for deleting user")
	public void removeUserTest() {
		User user = new User(1, "sa", "email", "password", "job", "202020", "pune");
		userService.removeUser(1);
		verify(userRepository, times(1)).deleteById(1);
	}

	// Test for displaying all user
	@Test
	@DisplayName("Test for displaying all user")
	public void showAllUsersTest() {
		when(userRepository.findAll())
				.thenReturn(Stream
						.of(new User(1, "sa", "email", "pass", "job", "202020", "pune"),
								new User(2, "sahil", "email", "pass", "job", "202020", "pune"))
						.collect(Collectors.toList()));
		assertEquals(2, userService.showAllUsers().size());
	}

	// Test for displaying one user by using userid
	@Test
	@DisplayName("Test for displaying one user by id")
	public void showUserTest() {
		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
		when(userRepository.findById(1)).thenReturn(Optional.of(user));
		assertEquals(user, userService.showUser(1));
	}

	// Test for displaying exception all user
	@Test
	@DisplayName("Test for displaying exception all user")
	public void showAllUsersTestException() {
		List<User> allUser = new ArrayList<>();

		when(userRepository.findAll()).thenReturn(allUser);

		Exception exception = assertThrows(UserNotFoundException.class, () -> userService.showAllUsers());
		assertEquals("Users not found", exception.getMessage());
	}

	// Test for displaying exception one user by using userId
	@Test
	@DisplayName("Test for displaying exception one user by id")
	public void showUserTestException() {

		when(userRepository.findById(1)).thenReturn(Optional.empty());

		Exception exception = assertThrows(UserNotFoundException.class, () -> userService.showUser(1));
		assertEquals("User not found by userId", exception.getMessage());
	}

}
