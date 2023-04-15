package com.hotel.hotel.models;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="roomstype")
@Data
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int price;


    public void updateRoomType(RoomType roomType){
        if(roomType.name != null){
            this.name = roomType.name;
        }
        if(roomType.description != null){
            this.description = roomType.description;
        }
        if(roomType.price != 0){
            this.price = roomType.price;
        }
    }
}
