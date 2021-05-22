package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
