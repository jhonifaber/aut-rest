package com.aut.prueba.web.controller;

import com.aut.prueba.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/database/populate")
public class DatabaseController {

    private final DatabaseService databaseService;

    @PostMapping
    public void populateDatabase(){
        databaseService.fill();
    }
}
