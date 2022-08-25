package com.apaza.citas.service;



import com.apaza.citas.model.Specialty;

import com.apaza.citas.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpecialtyService {


    private final SpecialtyRepository repository;

    public SpecialtyService(SpecialtyRepository repository) {
        this.repository = repository;
    }

    public List<Specialty> listAll(){
        return repository.findAll();
    }

    public Specialty findbyId(String id){

       return repository.findById(id).orElse(null);
    }

    public Specialty save(Specialty  especialidad){
        return repository.save(especialidad);
    }
    public Specialty update(Specialty  especialidad){

        Specialty newEspecialidad = findbyId(especialidad.getId());

        if(especialidad.getDescription() != null)
            newEspecialidad.setDescription(especialidad.getDescription());



        return repository.save(newEspecialidad);
    }


}
