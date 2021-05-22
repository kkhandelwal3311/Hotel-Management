package com.cg.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hotel.entites.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
