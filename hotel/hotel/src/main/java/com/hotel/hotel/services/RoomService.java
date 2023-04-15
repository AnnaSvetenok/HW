package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Room getRoomById(Integer id){
        return roomRepository.findById(id).get();
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public void deleteRoom(Integer id){
        roomRepository.deleteById(id);
    }
}
