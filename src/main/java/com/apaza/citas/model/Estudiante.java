package com.apaza.citas.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foto;
    private String nombre;
    private String apellido;
    private LocalDate fecnac;
    private String telefono;
    private String correo;
    private String dni;

    private String estado;

    @PrePersist
    void preInsert() {
        estado = "disponible";
    }


    @ManyToOne
    private Carrera  carrera;




}
