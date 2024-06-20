package com.example.wigellcinema.service;

import com.example.wigellcinema.exceptions.ResourceNotFoundException;
import com.example.wigellcinema.models.Room;
import com.example.wigellcinema.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements RoomServiceInterface{
    @Autowired
    RoomRepository roomRepository;
    @Override
    public Room BookRoom(Room room) {
        if(!roomRepository.findAll().contains(room)){
          return  roomRepository.save(room);
        }
        throw new ResourceNotFoundException("Room with", "id", room + "not found");
    }

    @Override
    public Room UpdateRoom(int id, Room room) {
        if(roomRepository.existsById(id)){
            Room existingRoom = roomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Room with", "id", id + "not found"));
             existingRoom.setMaxGuests(room.getMaxGuests());
             existingRoom.setRoomType(room.getRoomType());
             return roomRepository.save(existingRoom);

        }
        throw new ResourceNotFoundException("Room with", "id", id + "Unable to Update");
    }
}
