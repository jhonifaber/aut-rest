package com.aut.prueba.web.controller;

import com.aut.prueba.model.Speaker;
import com.aut.prueba.service.SpeakerService;
import com.aut.prueba.web.presentation.SpeakerDto;
import com.aut.prueba.web.presentation.mapper.SpeakerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/speakers")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class SpeakerController {

    private final SpeakerService speakerService;
    private final SpeakerMapper speakerMapper;

    @GetMapping
    public List<SpeakerDto> getSpeakers() {
        List<Speaker> speakers = speakerService.getSpeakers();
        return speakers.stream().map(speakerMapper::convertToSpeakerDto).collect(Collectors.toList());
    }
}
