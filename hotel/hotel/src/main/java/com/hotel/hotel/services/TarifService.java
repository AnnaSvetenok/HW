package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Tarif;
import com.hotel.hotel.repositories.TarifRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TarifService {
    @Autowired
    private TarifRepository tarifRepository;

    public List<Tarif> getAllTarifs(){
        return tarifRepository.findAll();
    }

    public Tarif getTarifById(Integer id){
        return tarifRepository.findById(id).get();
    }

    public void saveTarif(Tarif tarif){
        tarifRepository.save(tarif);
    }

    public void deleteTarif(Integer id){
        tarifRepository.deleteById(id);
    }
}
