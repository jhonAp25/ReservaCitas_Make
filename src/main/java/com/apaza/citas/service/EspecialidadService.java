package com.apaza.citas.service;


import com.apaza.citas.model.Especialidad;
import com.apaza.citas.model.Especialista;
import com.apaza.citas.repository.EspecialidadRepository;
import com.apaza.citas.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository repository;

    public List<Especialidad> listAll(){
        return repository.findAll();
    }

    public Especialidad findbyId(Long id){

       return repository.findById(id).orElse(null);
    }

    public Especialidad save(Especialidad  especialidad){
        return repository.save(especialidad);
    }
    public Especialidad update(Especialidad  especialidad){

        Especialidad newEspecialidad = findbyId(especialidad.getId());

        if(especialidad.getDescripcion() != null)
            newEspecialidad.setDescripcion(especialidad.getDescripcion());



        return repository.save(newEspecialidad);
    }


}
