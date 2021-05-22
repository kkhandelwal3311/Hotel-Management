package com.cg.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.entites.Transaction;

import com.cg.hotel.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	Logger logger = LoggerFactory.getLogger(TransactionController.class);

	// Endpoint to make a new transaction
	@PostMapping("/transaction")
	public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
		logger.info("Entered addTransaction()");
		return transactionService.addTransaction(transaction);
	}

	// Endpoint to fetch all the Payment from database
	@GetMapping("/transaction")
	public List<Transaction> showAllTransaction() {
		logger.info("Entered showAllTransaction()");
		List<Transaction> allTransaction = transactionService.showAllTransaction();
		return allTransaction;
	}

}
