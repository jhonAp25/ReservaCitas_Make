package com.apaza.citas.repository;

import com.apaza.citas.model.Carrera;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarreraRepository extends MongoRepository<Carrera, String> {
}
