package com.apaza.citas.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;

    private String foto;
    private String nombre;
    private String apellido;
    private LocalDate fecnac;
    private String telefono;
    private String correo;
    private String dni;




    private Carrera  carrera;




}
