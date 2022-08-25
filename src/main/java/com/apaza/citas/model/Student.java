package com.apaza.citas.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private String photo;
    private String name;
    private String secondName;
    private LocalDate dataBirth;
    private String phone;
    private String email;
    private String dni;




    private Career  career;




}
