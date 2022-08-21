package com.apaza.citas.service;


import com.apaza.citas.model.Carrera;
import com.apaza.citas.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {


    private final CarreraRepository repository;

    public CarreraService(CarreraRepository repository) {
        this.repository = repository;
    }


    public List<Carrera> listAll(){
        return repository.findAll();
    }

    public Carrera findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public Carrera save(Carrera  carrera){
        return repository.save(carrera);
    }
    public Carrera update(Carrera  carrera){

        Carrera newCarrera = findbyId(carrera.getId());

        if(carrera.getDescripcion() != null)
            newCarrera.setDescripcion(carrera.getDescripcion());



        return repository.save(newCarrera);
    }

}
