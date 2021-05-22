package com.cg.hotel.transactionservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hotel.entites.Transaction;
import com.cg.hotel.exception.TransactionNotFoundException;
import com.cg.hotel.repository.TransactionRepository;
import com.cg.hotel.service.TransactionService;

@SpringBootTest
class TransactionTests {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Autowired
	private TransactionService transactionService;

	@MockBean
	private TransactionRepository transactionRepository;

	// Test for adding transaction
	@Test
	@DisplayName("Test for adding transaction")
	public void addTransactionTest() {
		Transaction transaction = new Transaction(12345678, 5000.00);
		when(transactionRepository.save(transaction)).thenReturn(transaction);
		assertEquals(transaction, transactionService.addTransaction(transaction));
	}

	// Test for displaying exception for all transaction
	@Test
	@DisplayName("Test for displaying exception for all transaction")
	public void showAllUsersTestException() {
		List<Transaction> allTransaction = new ArrayList<>();

		when(transactionRepository.findAll()).thenReturn(allTransaction);

		Exception exception = assertThrows(TransactionNotFoundException.class,
				() -> transactionService.showAllTransaction());
		assertEquals("Transactions not found", exception.getMessage());
	}

}
