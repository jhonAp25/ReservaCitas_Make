package com.apaza.citas.repository;

import com.apaza.citas.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findCitaByFechaAndEspecialista_Especialidad_Id(LocalDate fecha, Long id);
    List<Cita> findAllByEstadoAndEspecialista_Especialidad_IdOrderByFecha( Boolean estado,Long id);
    List<Cita> findCitaByFechaAndEspecialista_Especialidad_IdAndEstado(LocalDate fecha, Long id, Boolean estado);
    List<Cita> findCitaByFechaAndEspecialista_Id(LocalDate fecha, Long id);



}
