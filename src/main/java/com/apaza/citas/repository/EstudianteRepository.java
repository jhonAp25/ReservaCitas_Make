package com.apaza.citas.repository;

import com.apaza.citas.model.Estudiante;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {

    List<Estudiante> findAllByNombreContainsOrApellidoContains (String nombr, String apel);

    Estudiante findAllByDni (String dni);

}
