package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
