package com.apaza.citas.model;


import dev.morphia.annotations.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "colas")
public class Cola {

    @Id
    private String id;
    private String estado;

    @PrePersist
    void preInsert() {
        estado = "ESPERA";
    }


    private Estudiante estudiante;
}
