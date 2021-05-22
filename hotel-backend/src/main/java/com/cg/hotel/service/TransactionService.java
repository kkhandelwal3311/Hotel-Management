package com.cg.hotel.service;

import java.util.List;

import com.cg.hotel.entites.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);

	public List<Transaction> showAllTransaction();

}
