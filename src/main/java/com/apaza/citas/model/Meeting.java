package com.apaza.citas.model;


import dev.morphia.annotations.PrePersist;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;


@Document(collection = "meetings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {

    @Id
    private String id;
    private LocalDate date;
    private LocalTime initTime;
    private boolean state;

    @PrePersist
    void preInsert() {
        state = true;
    }


    private Specialist specialist;

}
