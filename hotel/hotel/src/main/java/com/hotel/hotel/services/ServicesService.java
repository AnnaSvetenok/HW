package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Services;
import com.hotel.hotel.repositories.ServicesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    public List<Services> getAllServices(){
        return servicesRepository.findAll();
    }

    public Services getServicesById(Integer id){
        return servicesRepository.findById(id).get();
    }

    public void saveServices(Services services){
        servicesRepository.save(services);
    }

    public void deleteServices(Integer id){
        servicesRepository.deleteById(id);
    }
}
