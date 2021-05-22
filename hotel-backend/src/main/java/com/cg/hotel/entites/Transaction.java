package com.cg.hotel.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactions_seq")
	@SequenceGenerator(name = "transactions_seq", sequenceName = "transactions_seq", allocationSize = 1)
	@Column(name = "transaction_id")
	private int transactionId;

	@Column(name = "amount")
	@Min(value = 0, message = "Amount should not be less than 0")
	private double amount;

	public Transaction() {

	}

	public Transaction(int transactionId, double amount) {
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
