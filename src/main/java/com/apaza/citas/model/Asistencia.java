package com.apaza.citas.model;


import dev.morphia.annotations.PrePersist;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "asistencias")
@Data
public class Asistencia {

    @Id
    private String id;

    private String estado;


    private Estudiante estudiante;


    private Cita cita;

    @PrePersist
    void preInsert() {
        estado = "PENDIENTE";
    }

}
