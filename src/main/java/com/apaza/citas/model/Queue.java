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
@Document(collection = "queues")
public class Queue {

    @Id
    private String id;
    private String state;

    @PrePersist
    void preInsert() {
        state = "WAITING";
    }


    private Student student;
}
