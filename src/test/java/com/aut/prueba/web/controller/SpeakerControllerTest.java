package com.aut.prueba.web.controller;

import com.aut.prueba.model.Speaker;
import com.aut.prueba.service.SpeakerService;
import com.aut.prueba.web.presentation.SpeakerDto;
import com.aut.prueba.web.presentation.mapper.SpeakerMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpeakerControllerTest {

    private final SpeakerService speakerService = mock(SpeakerService.class);
    private final SpeakerMapper speakerMapper = Mappers.getMapper(SpeakerMapper.class);
    private SpeakerController sut = new SpeakerController(speakerService, speakerMapper);


    @Test
    public void get_speakers() {
        List<Speaker> speakers = List.of(Speaker.builder().build());
        when(speakerService.getSpeakers()).thenReturn(speakers);
        List<SpeakerDto> expectedSpeakersDto = speakers.stream().map(speakerMapper::convertToSpeakerDto).collect(Collectors.toList());

        List<SpeakerDto> result = sut.getSpeakers();

        assertThat(result, is(expectedSpeakersDto));

    }
}
