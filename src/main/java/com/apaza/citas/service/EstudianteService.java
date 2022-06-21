package com.apaza.citas.service;


import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    public List<Estudiante> listAll(){
        return repository.findAll();
    }


}
