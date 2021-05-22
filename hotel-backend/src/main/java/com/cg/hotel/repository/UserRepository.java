package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
