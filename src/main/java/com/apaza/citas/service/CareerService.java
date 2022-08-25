package com.apaza.citas.service;


import com.apaza.citas.model.Career;

import com.apaza.citas.repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {


    private final CareerRepository repository;

    public CareerService(CareerRepository repository) {
        this.repository = repository;
    }


    public List<Career> listAll(){
        return repository.findAll();
    }

    public Career findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public Career save(Career  carrera){
        return repository.save(carrera);
    }
    public Career update(Career  carrera){

        Career newCarrera = findbyId(carrera.getId());

        if(carrera.getDescription() != null)
            newCarrera.setDescription(carrera.getDescription());



        return repository.save(newCarrera);
    }

}
