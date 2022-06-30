package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Cupos;
import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.repository.CuposRepository;
import com.apaza.citas.repository.ReservaCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaCitaService {

    @Autowired
    private ReservaCitaRepository repository;

    @Autowired
    private CuposService cuposService;

    public List<ReservaCita> listAll(){
        return repository.findAll();
    }

    public ReservaCita findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public ReservaCita save(ReservaCita  cita){

        Cupos cupos = cita.getCupos();

        cuposService.updateEstado(cupos);


        return repository.save(cita);
    }
    public ReservaCita update(ReservaCita  cita){

        ReservaCita newCita = findbyId(cita.getId());

        //FALTA mas campos



        return repository.save(newCita);
    }
}
