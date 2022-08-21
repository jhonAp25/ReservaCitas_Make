package com.apaza.citas.repository;

import com.apaza.citas.model.ReservaCita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservaCitaRepository extends MongoRepository<ReservaCita ,String> {

    ReservaCita  findAllByCita_Id(String id);
    List<ReservaCita> findAllByEstudiante_Id(String id);
}
