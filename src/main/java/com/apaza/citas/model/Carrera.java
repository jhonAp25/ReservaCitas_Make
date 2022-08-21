package com.apaza.citas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "carreras")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {

    @Id
    private String id;
    private String descripcion;
}
