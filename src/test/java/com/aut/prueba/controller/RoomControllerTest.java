package com.aut.prueba.controller;

import com.aut.prueba.model.Room;
import com.aut.prueba.service.RoomService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoomControllerTest {
    private final RoomService roomService = mock(RoomService.class);
    private RoomController sut = new RoomController(roomService);

    @Test
    public void get_rooms_should_return_rooms() {
        List<Room> expectedRoomsList = List.of(Room.builder().build());
        when(roomService.getRooms()).thenReturn(expectedRoomsList);

        List<Room> rooms = sut.getRooms();

        assertThat(rooms, is(expectedRoomsList));
    }

}