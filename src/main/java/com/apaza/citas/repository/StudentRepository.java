package com.apaza.citas.repository;


import com.apaza.citas.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAllByNombreContainsOrApellidoContains (String nombr, String apel);

    Student findAllByDni (String dni);

}
