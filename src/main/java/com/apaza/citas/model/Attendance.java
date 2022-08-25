package com.apaza.citas.model;


import dev.morphia.annotations.PrePersist;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "attendances")
@Data
public class Attendance {

    @Id
    private String id;

    private String state;


    private Student student;


    private Meeting meeting;

    @PrePersist
    void preInsert() {
        state = "EARRING";
    }

}
