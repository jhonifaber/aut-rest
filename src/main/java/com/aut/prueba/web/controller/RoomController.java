package com.aut.prueba.web.controller;

import com.aut.prueba.model.Room;
import com.aut.prueba.service.RoomService;
import com.aut.prueba.web.presentation.RoomDto;
import com.aut.prueba.web.presentation.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping
    public List<RoomDto> getRooms() {
        List<Room> rooms = roomService.getRooms();
        return rooms.stream().map(roomMapper::convertToRoomDto).collect(Collectors.toList());
    }
}
