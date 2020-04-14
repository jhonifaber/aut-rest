package com.aut.prueba.web.controller;

import com.aut.prueba.model.Room;
import com.aut.prueba.service.RoomService;
import com.aut.prueba.web.presentation.RoomDto;
import com.aut.prueba.web.presentation.mapper.RoomMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoomControllerTest {
    private final RoomService roomService = mock(RoomService.class);
    private final RoomMapper roomMapper = Mappers.getMapper(RoomMapper.class);
    private RoomController sut = new RoomController(roomService, roomMapper);

    @Test
    public void get_rooms_should_return_rooms() {
        List<Room> rooms = List.of(Room.builder().build());
        when(roomService.getRooms()).thenReturn(rooms);
        List<RoomDto> expectedRoomsDto = rooms.stream().map(roomMapper::convertToRoomDto).collect(Collectors.toList());

        List<RoomDto> result = sut.getRooms();

        assertThat(result, is(expectedRoomsDto));
    }

}