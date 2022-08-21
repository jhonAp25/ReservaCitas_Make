package com.apaza.citas.repository;

import com.apaza.citas.model.Cita;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {

    List<Cita> findCitaByFechaAndEspecialista_Especialidad_Id(LocalDate fecha, String id);
    List<Cita> findAllByEstadoAndEspecialista_Especialidad_IdOrderByFecha( Boolean estado,String id);
    List<Cita> findCitaByFechaAndEspecialista_Especialidad_IdAndEstado(LocalDate fecha, String id, Boolean estado);
    List<Cita> findCitaByEspecialista_IdAndFechaAfter( String id,LocalDate fecha);
    Long countAllByFecha(LocalDate date);


}
