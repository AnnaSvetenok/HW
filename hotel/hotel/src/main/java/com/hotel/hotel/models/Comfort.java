package com.hotel.hotel.models;

import java.util.Set;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="comforts")
@Data
public class Comfort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    public void updateComfort(Comfort comfort){
        if(comfort.name != null){
            this.name = comfort.name;
        }
    }

    @ManyToMany
    @JoinTable(
            name = "rooms_comforts",
            joinColumns = @JoinColumn(name="comfort_id"),
            inverseJoinColumns = @JoinColumn(name="room_id"))
    private Set<Room> rooms;
}
