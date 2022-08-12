package com.apaza.citas.repository;

import com.apaza.citas.model.Asistencia;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia , Long> {

    List<Asistencia> findAllByEstudiante_Id(Long id);
    List<Asistencia> findAllByOrderByCitaAsc();
    Asistencia findAllByCita_IdAndEstado(Long id, String estado);
    List<Asistencia> findAllByCita_Especialista_IdAndCita_Fecha(Long id, LocalDate fecha);

//    List<Asistencia> findAllByCita_FechaOrCita_Especialista_IdOrEstado(LocalDate fecha, Long idEspecialista , String estado);
//    List<Asistencia> findAllByCita_FechaAndCita_Especialista_IdAndEstado (LocalDate fecha, Long idEspecialista, String estado );
//    List<Asistencia> findAllByCita_FechaAndCita_Especialista_Id (LocalDate fecha, Long idEspecialista );
//    List<Asistencia> findAllByCita_FechaAndEstado (LocalDate fecha, Long idEspecialista );



}
