package com.aut.prueba.web.presentation.mapper;

import com.aut.prueba.model.Room;
import com.aut.prueba.web.presentation.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto convertToRoomDto(Room room);

    Room convertToRoom(RoomDto roomDto);
}
