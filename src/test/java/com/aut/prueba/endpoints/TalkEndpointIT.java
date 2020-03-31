package com.aut.prueba.endpoints;

import com.aut.prueba.RestApplication;
import com.aut.prueba.model.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)// extendWith es de Junit 5, @Runwith de Junit 4
@SpringBootTest(classes = RestApplication.class)
public class TalkEndpointIT {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void foo(){
        Room room = em.find(Room.class, 1L);
        room.getNumber();
    }
}
