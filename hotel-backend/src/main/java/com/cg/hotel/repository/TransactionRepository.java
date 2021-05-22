package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
