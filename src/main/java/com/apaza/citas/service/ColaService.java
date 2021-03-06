package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Cola;
import com.apaza.citas.repository.ColaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaService {

    @Autowired
    private ColaRepository repository;

    public List<Cola> listAll(){
        return repository.findAll();
    }

    public Cola findByIdEstudiante(Long id){
        return repository.findAllByEstudiante_Id(id);
    }

    public Cola findById(Long id){
        return repository.findById(id).orElse(null);
    }


    public List<Cola> findColaEspera(){
        return repository.findAllByEstado("ESPERA");
    }


    public Cola save(Cola cola){
        return repository.save(cola);
    }

    public Cola updateEstado(Long idCola , String estado){

        Cola newCola = findById(idCola);

        newCola.setEstado(estado);
        return repository.save(newCola);
    }
}
