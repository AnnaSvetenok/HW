package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Comfort;

public interface ComfortRepository extends JpaRepository<Comfort, Integer> {
    List<Comfort> findByName(String name);
}
