package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Comfort;
import com.hotel.hotel.repositories.ComfortRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComfortService {
    @Autowired
    private ComfortRepository comfortRepository;

    public List<Comfort> getAllComforts(){
        return comfortRepository.findAll();
    }
    public Comfort getComfortByName(String name){
        return (Comfort) comfortRepository.findByName(name);
    }

    public void saveComfort(Comfort comfort){
        comfortRepository.save(comfort);
    }

    public void deleteComfort(Integer id){
        comfortRepository.deleteById(id);
    }

}
