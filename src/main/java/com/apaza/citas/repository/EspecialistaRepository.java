package com.apaza.citas.repository;

import com.apaza.citas.model.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialistaRepository extends JpaRepository<Especialista, Long>{

    Especialista findAllByDni(String dni);
}
