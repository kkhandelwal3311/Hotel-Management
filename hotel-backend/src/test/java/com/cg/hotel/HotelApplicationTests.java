package com.cg.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Autowired
//	private UserService userService;
//	
//	@MockBean
//	private UserRepository userRepository;
//	
//	@Test
//	@DisplayName("Test for adding user")
//	public void addUserTest() {
//		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
//		when(userRepository.save(user)).thenReturn(user);
//		assertEquals(user, userService.addUser(user));
//	}
//	
//	@Test
//	@DisplayName("Test for updating user")
//	public void updateUserTest() {
//		User user = new User(1, "sa", "email", "password", "job", "202020", "pune");
//		when(userRepository.save(user)).thenReturn(user);
//		assertEquals(user, userService.updateUser(user));
//	}
//	
//	@Test
//	@DisplayName("Test for deleting user")
//	public void removeUserTest() {
//		User user = new User(1, "sa", "email", "password", "job", "202020", "pune");
//		userRepository.deleteById(1);
//		assertEquals(null, userService.showUser(1));
//	}
//	
//	@Test
//	@DisplayName("Test for displaying all user")
//	public void showAllUsersTest(){
//		when(userRepository.findAll()).thenReturn(Stream.of(new User(1, "sa", "email", "pass", "job", "202020", "pune"), 
//				new User(2, "sahil", "email", "pass", "job", "202020", "pune")).collect(Collectors.toList()));
//		assertEquals(2, userService.showAllUsers().size());
//	}
//	
//	@Test
//	@DisplayName("Test for displaying one user by id")
//	public void showUserTest() {
//		User user = new User(1, "sa", "email", "pass", "job", "202020", "pune");
//		when(userRepository.findById(1)).thenReturn(Optional.of(user));
//        assertEquals(user, userService.showUser(1));
//	}

}
