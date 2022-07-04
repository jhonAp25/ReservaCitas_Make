package com.apaza.citas.repository;

import com.apaza.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    Cita findCitaByFechaAndAndEspecialista_Id(LocalDate fecha, Long id);
}
