package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer>{
    List<Services> findByName(String name);
}

