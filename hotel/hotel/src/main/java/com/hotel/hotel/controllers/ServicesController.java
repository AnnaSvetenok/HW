package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Services;
import com.hotel.hotel.services.ServicesService;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable Integer id){
        try{
            Services services = servicesService.getServicesById(id);
            return new ResponseEntity<Services>(services, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Services>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public List<Services> getAllServices(){
        return servicesService.getAllServices();
    }

    @PostMapping("/")
    public void saveServices(@RequestBody Services services){
        servicesService.saveServices(services);
    }

    @DeleteMapping("/{id}")
    public void deleteServices(@PathVariable Integer id){
        servicesService.deleteServices(id);
    }
}
