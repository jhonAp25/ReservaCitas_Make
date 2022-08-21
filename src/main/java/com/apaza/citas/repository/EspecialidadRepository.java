package com.apaza.citas.repository;

import com.apaza.citas.model.Especialidad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialidadRepository extends MongoRepository<Especialidad, String> {

}
