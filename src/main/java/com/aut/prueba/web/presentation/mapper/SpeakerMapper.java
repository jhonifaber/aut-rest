package com.aut.prueba.web.presentation.mapper;

import com.aut.prueba.model.Speaker;
import com.aut.prueba.web.presentation.SpeakerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpeakerMapper {
    SpeakerDto convertToSpeakerDto(Speaker speaker);

    Speaker convertToSpeaker(SpeakerDto speakerDto);
}
