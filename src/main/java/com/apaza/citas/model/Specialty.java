package com.apaza.citas.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "specialty")
@Data
public class Specialty {

    @Id
    private String id;

    private String description;
}
