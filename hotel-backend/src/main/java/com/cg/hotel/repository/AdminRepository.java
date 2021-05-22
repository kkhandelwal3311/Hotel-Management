package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
