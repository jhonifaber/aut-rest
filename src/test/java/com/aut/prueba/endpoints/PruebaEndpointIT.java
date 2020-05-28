package com.aut.prueba.endpoints;

import com.aut.prueba.security.AuthenticationRequest;
import com.aut.prueba.security.AuthenticationResponse;
import com.aut.prueba.service.DatabaseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Testcontainers
public abstract class PruebaEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    protected DatabaseService databaseService;

    @LocalServerPort
    private int port;

    @Container
    public static final MySQLContainer mysql = new MySQLContainer("mysql:latest");

    @BeforeAll
    private void initDatabase() {
        System.setProperty("spring.datasource.url", mysql.getJdbcUrl());
        System.setProperty("spring.datasource.username", mysql.getUsername());
        System.setProperty("spring.datasource.password", mysql.getPassword());
        databaseService.fill();
    }

    public String createUrlWith(String endpoint) {
        return "http://localhost:" + port + endpoint;
    }

    public TestRestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    public HttpHeaders makeRequestLogin() {
        AuthenticationRequest loginRequest = AuthenticationRequest.builder().username("any").password("pass").build();
        ResponseEntity<AuthenticationResponse> loginResponse = getRestTemplate().postForEntity(createUrlWith("/login"), loginRequest, AuthenticationResponse.class);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + loginResponse.getBody().getToken());
        return headers;
    }

    protected void rollback() {
        databaseService.fill();
    }
}
