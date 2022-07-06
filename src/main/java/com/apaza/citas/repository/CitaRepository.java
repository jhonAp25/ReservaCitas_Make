package com.apaza.citas.repository;

import com.apaza.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findCitaByFechaAndAndEspecialista_Id(LocalDate fecha, Long id);

    List<Cita> findCitaByFechaAndEspecialista_IdAndEstado(LocalDate fecha, Long id, Boolean estado);

}
