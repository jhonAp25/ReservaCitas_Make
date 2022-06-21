package com.apaza.citas.repository;

import com.apaza.citas.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
