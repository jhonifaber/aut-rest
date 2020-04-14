package com.aut.prueba.web.presentation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TalkDto {

    private Long id;

    private String name;

    private LocalDate date;

    private SpeakerDto speaker;

    private RoomDto room;
}
