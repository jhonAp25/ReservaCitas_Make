package com.apaza.citas.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document(collection = "specialists")
@Data
public class Specialist {

    @Id
    private String id;
    private String name;
    private String secondName;
    private String phone;
    private String email;
    private LocalDate dateBirth;
    private String dni;


    private Specialty specialty;

}
