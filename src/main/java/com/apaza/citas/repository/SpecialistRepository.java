package com.apaza.citas.repository;

import com.apaza.citas.model.Specialist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialistRepository extends MongoRepository<Specialist, String> {

    Specialist findAllByDni(String dni);
}
