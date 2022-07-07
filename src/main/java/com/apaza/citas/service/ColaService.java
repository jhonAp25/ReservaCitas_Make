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

    public Cola findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cola> findColaEspera(){
        return repository.findAllByEstado("ESPERA");
    }


    public Cola save(Cola cola){
        return repository.save(cola);
    }

    public Cola updateEstado(Long idCita , String estado){

        Cola newCola = findById(idCita);

        newCola.setEstado(estado);
        return repository.save(newCola);
    }
}
