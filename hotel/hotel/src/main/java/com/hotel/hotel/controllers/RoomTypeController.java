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

import com.hotel.hotel.models.RoomType;
import com.hotel.hotel.services.RoomTypeService;

@RestController
@RequestMapping("/rooms_types")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> getRoomTypeById(@PathVariable Integer id){
        try{
            RoomType roomType = roomTypeService.getRoomTypeById(id);
            return new ResponseEntity<RoomType>(roomType, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<RoomType>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public List<RoomType> getAllRoomTypes(){
        return roomTypeService.getAllRoomTypes();
    }

    @PostMapping("/")
    public void saveRoomType(@RequestBody RoomType roomType){
        roomTypeService.saveRoomType(roomType);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomType(@PathVariable Integer id){
        roomTypeService.deleteRoomType(id);
    }

}
