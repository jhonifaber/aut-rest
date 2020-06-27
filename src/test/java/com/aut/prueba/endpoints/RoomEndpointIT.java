package com.aut.prueba.endpoints;

import com.aut.prueba.web.presentation.RoomDto;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class RoomEndpointIT extends PruebaEndpointIT {


    @Test
    public void room_endpoint_should_create_new_room() {
        HttpHeaders headers = makeRequestLogin();
        RoomDto body = RoomDto.builder().number(192L).build();
        HttpEntity entity = new HttpEntity(body,headers);

        ResponseEntity<Void> response = getRestTemplate().exchange(createUrlWith("/rooms"), HttpMethod.POST, entity, Void.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//        rollback();
    }

    @Test
    public void room_endpoint_should_return_all_rooms() {
        HttpHeaders headers = makeRequestLogin();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<RoomDto>> response = getRestTemplate().exchange(createUrlWith("/rooms"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<RoomDto>>() {
        });

        List<RoomDto> body = response.getBody();
        assertThat(body.size(), equalTo(1));
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
