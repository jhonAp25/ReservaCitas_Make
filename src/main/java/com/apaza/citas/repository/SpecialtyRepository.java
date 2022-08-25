package com.apaza.citas.repository;

import com.apaza.citas.model.Specialty;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecialtyRepository extends MongoRepository<Specialty, String> {

}
