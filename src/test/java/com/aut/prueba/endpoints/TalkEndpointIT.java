package com.aut.prueba.endpoints;

import com.aut.prueba.model.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class TalkEndpointIT {


    @Autowired
    private WebTestClient webTestClient;


    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void foo() {
         webTestClient.get().exchange().expectStatus().isOk();
        Room room = em.find(Room.class, 1L);
        room.getNumber();
    }
}
