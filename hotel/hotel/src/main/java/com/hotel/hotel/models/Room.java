package com.hotel.hotel.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String floor;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "room")
    private Set<Comfort> comforts;

    public void updateRoom(Room room){
        if(room.name != null){
            this.name = room.name;
        }
        if(room.floor != null){
            this.floor = room.floor;
        }
        if(room.description != null){
            this.description = room.description;
        }
    }
}
