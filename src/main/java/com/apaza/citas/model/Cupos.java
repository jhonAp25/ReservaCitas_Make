package com.apaza.citas.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
public class Cupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaInicio;
    private LocalTime horaFin;
    private boolean estado;

    @ManyToOne
    @JsonIgnore
    private Cita cita;

    @PrePersist
    void preInsert() {
        estado = true;
    }


}
