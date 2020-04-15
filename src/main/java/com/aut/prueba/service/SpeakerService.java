package com.aut.prueba.service;

import com.aut.prueba.model.Speaker;
import com.aut.prueba.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakerService {

    private final SpeakerRepository speakerRepository;

    public List<Speaker> getSpeakers() {
        return speakerRepository.findAll();
    }
}
