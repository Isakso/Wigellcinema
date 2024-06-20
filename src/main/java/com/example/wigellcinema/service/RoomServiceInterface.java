package com.example.wigellcinema.service;

import com.example.wigellcinema.models.Room;

public interface RoomServiceInterface {
    Room BookRoom(Room room);
    Room UpdateRoom(int id, Room room);
}
