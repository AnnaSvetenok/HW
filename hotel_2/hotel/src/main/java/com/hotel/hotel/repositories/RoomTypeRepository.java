package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer>{
    List<RoomType> findByName(String name);
}

