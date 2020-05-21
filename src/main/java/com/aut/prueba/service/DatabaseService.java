package com.aut.prueba.service;

import com.aut.prueba.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final RoomService roomService;

    public void fill() {
        Room room1 = Room.builder().number(12L).build();
        roomService.createRoom(room1);
    }
}
