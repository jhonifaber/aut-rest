create table room
(
    id     mediumint auto_increment,
    number int null,
    constraint room_pk primary key (id)
);

create table speaker
(
    id   mediumint auto_increment,
    name varchar(100) null,
    constraint speaker_pk primary key (id)
);

create table talk
(
    id         mediumint auto_increment,
    name       varchar(100) not null,
    date       datetime     not null,
    room_id    mediumint    not null,
    speaker_id mediumint    not null,
    constraint talk_pk
        primary key (id),
    constraint talk_room_id_fk
        foreign key (room_id) references room (id),
    constraint talk_speaker_id_fk
        foreign key (speaker_id) references speaker (id)
);
