package com.apaza.citas.repository;

import com.apaza.citas.model.Cola;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ColaRepository extends MongoRepository<Cola, String> {

    List<Cola> findAllByEstado (String estado);
    Cola findAllByEstudiante_Id(String id);
    Boolean existsAllByEstudiante_Id(String id);
}
