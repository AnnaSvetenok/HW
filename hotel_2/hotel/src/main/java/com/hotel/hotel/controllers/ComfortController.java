package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.hotel.hotel.models.Client;
import com.hotel.hotel.models.Order;
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

import com.hotel.hotel.models.Comfort;
import com.hotel.hotel.services.ComfortService;

@RestController
@RequestMapping("/comforts")
public class ComfortController {
    @Autowired
    private ComfortService comfortService;

    @GetMapping("/{name}")
    public ResponseEntity<Comfort> getComfortByName(@PathVariable String name){
        try{
            Comfort comfort = comfortService.getComfortByName(name);
            return new ResponseEntity<Comfort>(comfort, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Comfort>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value="")
    public List<Comfort> getAllComforts() {
        return comfortService.getAllComforts();
    }

    @DeleteMapping("/{id}")
    public void deleteComfort(@PathVariable Integer id){
        comfortService.deleteComfort(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComfort(@RequestBody Comfort comfort, @PathVariable String name){
        try{
            Comfort baseComfort = comfortService.getComfortByName(name);
            baseComfort.updateComfort(comfort);
            comfortService.saveComfort(baseComfort);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
