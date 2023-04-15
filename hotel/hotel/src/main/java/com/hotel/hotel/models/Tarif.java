package com.hotel.hotel.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tarifs")
@Data
public class Tarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String room;
    private String roomType;
    private int price;

    @JsonIgnore
    @ManyToMany(mappedBy = "tarif")
    private Set<Services> services;

    public void updateTarif(Tarif tarif){
        if(tarif.room != null){
            this.room = tarif.room;
        }
        if(tarif.roomType != null){
            this.roomType = tarif.roomType;
        }
        if(tarif.price != 0){
            this.price = tarif.price;
        }
    }
}
