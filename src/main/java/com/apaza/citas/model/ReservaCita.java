package com.apaza.citas.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ReservaCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToOne
    private Estudiante estudiante;

    @ManyToOne
    private Cita cita;


}
