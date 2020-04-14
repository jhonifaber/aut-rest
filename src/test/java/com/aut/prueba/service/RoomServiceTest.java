package com.aut.prueba.service;

import com.aut.prueba.model.Room;
import com.aut.prueba.repository.RoomRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RoomServiceTest {
    private final RoomRepository roomRepository = mock(RoomRepository.class);
    private final RoomService sut = new RoomService(roomRepository);

    @Test
    public void getRooms() {
        List<Room> expectedRooms = List.of(Room.builder().build());
        when(roomRepository.findAll()).thenReturn(expectedRooms);

        List<Room> rooms = sut.getRooms();

        assertThat(rooms, is(expectedRooms));
    }
}