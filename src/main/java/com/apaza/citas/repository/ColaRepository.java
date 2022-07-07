package com.apaza.citas.repository;

import com.apaza.citas.model.Cola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaRepository extends JpaRepository<Cola, Long> {

    List<Cola> findAllByEstado (String estado);
}
