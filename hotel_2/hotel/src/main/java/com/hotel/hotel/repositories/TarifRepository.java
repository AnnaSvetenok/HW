package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Tarif;

public interface TarifRepository extends JpaRepository<Tarif, Integer>{
    List<Tarif> findByName(String name);
}

