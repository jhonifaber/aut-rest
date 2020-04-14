package com.aut.prueba.endpoints;

import com.aut.prueba.web.presentation.RoomDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class RoomEndpointIT extends PruebaEndpointIT {

    @Test
    public void room_endpoint_should_return_all_rooms() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<RoomDto>> response = getRestTemplate().exchange(createUrlWith("/rooms"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<RoomDto>>() {
        });

        List<RoomDto> body = response.getBody();
        assertThat(body.size(), equalTo(1));
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
