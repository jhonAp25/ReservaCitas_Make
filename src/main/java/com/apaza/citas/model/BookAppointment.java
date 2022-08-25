package com.apaza.citas.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "book_appointment")
@Data
public class BookAppointment {

    @Id
    private String id;
    private String description;


    private Student student;


    private Meeting meeting;



}
