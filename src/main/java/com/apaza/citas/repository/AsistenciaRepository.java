package com.apaza.citas.repository;

import com.apaza.citas.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia , Long> {

    List<Asistencia> findAllByEstudiante_Id(Long id);
    Asistencia findAllByCita_Id(Long id);
}
