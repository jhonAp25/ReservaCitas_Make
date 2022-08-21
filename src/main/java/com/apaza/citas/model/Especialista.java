package com.apaza.citas.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document(collection = "especialistas")
@Data
public class Especialista {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private LocalDate fecnac;
    private String dni;


    private Especialidad especialidad;

}
