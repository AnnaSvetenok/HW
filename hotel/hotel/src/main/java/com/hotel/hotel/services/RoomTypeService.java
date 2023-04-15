package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.RoomType;
import com.hotel.hotel.repositories.RoomTypeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllRoomTypes(){
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(Integer id){
        return roomTypeRepository.findById(id).get();
    }

    public void saveRoomType(RoomType roomType){
        roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Integer id){
        roomTypeRepository.deleteById(id);
    }
}
