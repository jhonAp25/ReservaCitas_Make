package com.apaza.citas.repository;

import com.apaza.citas.model.Asistencia;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends MongoRepository<Asistencia , String> {

    List<Asistencia> findAllByEstudiante_Id(String id);
    List<Asistencia> findAllByOrderByCitaAsc();
    Asistencia findAllByCita_IdAndEstado(String id, String estado);
    List<Asistencia> findAllByCita_Especialista_IdAndCita_Fecha(String id, LocalDate fecha);

//    List<Asistencia> findAllByCita_FechaOrCita_Especialista_IdOrEstado(LocalDate fecha, Long idEspecialista , String estado);
//    List<Asistencia> findAllByCita_FechaAndCita_Especialista_IdAndEstado (LocalDate fecha, Long idEspecialista, String estado );
//    List<Asistencia> findAllByCita_FechaAndCita_Especialista_Id (LocalDate fecha, Long idEspecialista );
//    List<Asistencia> findAllByCita_FechaAndEstado (LocalDate fecha, Long idEspecialista );



}
