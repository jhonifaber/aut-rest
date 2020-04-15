package com.aut.prueba.service;

import com.aut.prueba.model.Speaker;
import com.aut.prueba.repository.SpeakerRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SpeakerServiceTest {

    private final SpeakerRepository speakerRepository = mock(SpeakerRepository.class);
    private SpeakerService sut = new SpeakerService(speakerRepository);

    @Test
    public void get_speakers() {
        List<Speaker> expectedSpeakers = List.of(Speaker.builder().build());
        when(speakerRepository.findAll()).thenReturn(expectedSpeakers);

        List<Speaker> speakers = sut.getSpeakers();

        assertThat(speakers, is(expectedSpeakers));
    }

}