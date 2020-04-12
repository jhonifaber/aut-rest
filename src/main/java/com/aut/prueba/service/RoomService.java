package com.aut.prueba.service;

import com.aut.prueba.model.Room;
import com.aut.prueba.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public List<Room> getRooms() {
       return roomRepository.findAll();
    }
}
