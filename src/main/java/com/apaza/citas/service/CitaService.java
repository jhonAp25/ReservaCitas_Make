package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Especialidad;
import com.apaza.citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository repository;

    public List<Cita> listAll(){
        return repository.findAll();
    }

    public Cita findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Cita findFechaEspecialidad(LocalDate fecha, Long id){
        return repository.findCitaByFechaAndAndEspecialista_Id(fecha,id);
    }

    public Cita save(Cita  cita){
        return repository.save(cita);
    }
    public Cita update(Cita  cita){

        Cita newCita = findbyId(cita.getId());

        //FALTA mas campos
        if(cita.getFecha()!= null)
            newCita.setFecha(cita.getFecha());



        return repository.save(newCita);
    }
}
