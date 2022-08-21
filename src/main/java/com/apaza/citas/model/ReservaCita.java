package com.apaza.citas.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "reserva_citas")
@Data
public class ReservaCita {

    @Id
    private String id;
    private String descripcion;


    private Estudiante estudiante;


    private Cita cita;



}
