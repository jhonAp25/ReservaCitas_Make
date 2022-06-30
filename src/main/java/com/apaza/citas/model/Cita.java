package com.apaza.citas.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private int nrocupos;

    @ManyToOne
    private Especialista especialista;


    @OneToMany
    private  List<Cupos> cupos;


}
