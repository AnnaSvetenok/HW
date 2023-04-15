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

import com.hotel.hotel.models.Tarif;
import com.hotel.hotel.services.TarifService;

@RestController
@RequestMapping("/tarifs")
public class TarifController {
    @Autowired
    private TarifService tarifService;

    @GetMapping("/{id}")
    public ResponseEntity<Tarif> getTarifById(@PathVariable Integer id){
        try{
            Tarif tarif = tarifService.getTarifById(id);
            return new ResponseEntity<Tarif>(tarif, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Tarif>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public List<Tarif> getAllTarifs(){
        return tarifService.getAllTarifs();
    }

    @PostMapping("/")
    public void saveTarif(@RequestBody Tarif tarif){
        tarifService.saveTarif(tarif);
    }

    @DeleteMapping("/{id}")
    public void deleteTarif(@PathVariable Integer id){
        tarifService.deleteTarif(id);
    }
}
