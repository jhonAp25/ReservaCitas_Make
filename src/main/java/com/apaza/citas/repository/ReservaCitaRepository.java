package com.apaza.citas.repository;

import com.apaza.citas.model.ReservaCita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaCitaRepository extends JpaRepository<ReservaCita ,Long> {

    ReservaCita  findAllByCupos_Id (Long id);
}
