package com.apaza.citas.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Especialista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private LocalDate fecnac;
    private String dni;

    @ManyToOne
    private Especialidad especialidad;

}
