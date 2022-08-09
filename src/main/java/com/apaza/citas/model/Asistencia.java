package com.apaza.citas.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    @ManyToOne
    private Estudiante estudiante;

    @ManyToOne
    private Cita cita;

    @PrePersist
    void preInsert() {
        estado = "PENDIENTE";
    }

}
