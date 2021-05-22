package com.cg.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hotel.entites.Transaction;
import com.cg.hotel.exception.TransactionNotFoundException;
import com.cg.hotel.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	// method to add new transaction
	@Override
	public Transaction addTransaction(Transaction transaction) {
		logger.info("Entered service addTransaction()");
		return transactionRepository.save(transaction);

	}

	// method to fetch all the transactions
	@Override
	public List<Transaction> showAllTransaction() {
		logger.info("Entered service showAllTransaction()");
		List<Transaction> allTransaction = transactionRepository.findAll();
		if (allTransaction.isEmpty()) {
			throw new TransactionNotFoundException("Transactions not found");
		}
		return allTransaction;
	}

}
