package com.apaza.citas.service;


import com.apaza.citas.model.Especialidad;

import com.apaza.citas.repository.EspecialidadRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EspecialidadService {


    private final EspecialidadRepository repository;

    public EspecialidadService(EspecialidadRepository repository) {
        this.repository = repository;
    }

    public List<Especialidad> listAll(){
        return repository.findAll();
    }

    public Especialidad findbyId(String id){

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
