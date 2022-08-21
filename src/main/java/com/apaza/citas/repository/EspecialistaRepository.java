package com.apaza.citas.repository;

import com.apaza.citas.model.Especialista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EspecialistaRepository extends MongoRepository<Especialista, String> {

    Especialista findAllByDni(String dni);
}
