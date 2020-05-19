package com.aut.prueba.endpoints;

import com.aut.prueba.security.AuthenticationRequest;
import com.aut.prueba.security.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public abstract class PruebaEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    public String createUrlWith(String endpoint) {
        return "http://localhost:" + port + endpoint;
    }

    public TestRestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    public HttpHeaders makeRequestLogin() {
        AuthenticationRequest loginRequest = AuthenticationRequest.builder().username("any").password("pass").build();
        ResponseEntity<AuthenticationResponse> loginResponse = getRestTemplate().postForEntity(createUrlWith( "/login"), loginRequest, AuthenticationResponse.class);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + loginResponse.getBody().getToken());
        return headers;
    }
}
