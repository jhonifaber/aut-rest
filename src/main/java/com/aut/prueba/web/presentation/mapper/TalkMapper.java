package com.aut.prueba.web.presentation.mapper;

import com.aut.prueba.model.Talk;
import com.aut.prueba.web.presentation.TalkDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TalkMapper {

    TalkDto convertToTalkDto(Talk talk);

    Talk convertToTalk(TalkDto talkdto);

}
