package com.aut.prueba.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/talks")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class TalkController {

    @GetMapping()
    public String getTalk(){
        return "Hello world";
    }
}
