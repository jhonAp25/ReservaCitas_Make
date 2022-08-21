package com.apaza.citas.model;


import dev.morphia.annotations.PrePersist;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;


@Document(collection = "citas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    private String id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private boolean estado;

    @PrePersist
    void preInsert() {
        estado = true;
    }


    private Especialista especialista;

}
