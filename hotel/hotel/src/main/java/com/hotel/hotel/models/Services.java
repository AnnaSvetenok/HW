package com.hotel.hotel.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name="services")
@Data
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price_increase;


    public void updateServices(Services services){
        if(services.name != null){
            this.name = services.name;
        }
        if(services.price_increase != 0){
            this.price_increase = services.price_increase;
        }
    }

    @ManyToMany
    @JoinTable(
            name = "services_tarifs",
            joinColumns = @JoinColumn(name="tarif_id"),
            inverseJoinColumns = @JoinColumn(name="service_id"))
    private Set<Tarif> tarifs;
}
