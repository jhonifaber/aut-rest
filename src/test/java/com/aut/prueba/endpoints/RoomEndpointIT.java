package com.aut.prueba.endpoints;

import com.aut.prueba.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoomEndpointIT extends PruebaEndpointIT {

    @Test
    public void foo() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Room>> response = getRestTemplate().exchange(createUrlWith("/rooms"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<Room>>() {
        });

        List<Room> body = response.getBody();
        assertThat(body.size()).isEqualTo(1);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
