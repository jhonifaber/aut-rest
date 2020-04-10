package com.aut.prueba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="talk")
public class Talk {

    @Id
    private Long id;

    private String name;

    private LocalDate date;

    @OneToOne
    private Speaker speaker;

    @OneToOne
    private Room room;
}
