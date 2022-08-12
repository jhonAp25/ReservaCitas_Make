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


    public Boolean save(Cola cola){
        if(ColaExistenteEstudiante(cola.getEstudiante().getId()))
            return false;
        repository.save(cola);
        return true;
    }
    public Boolean ColaExistenteEstudiante(Long id){
        return repository.existsAllByEstudiante_Id(id);
    }


    public Cola updateEstado(Long idEstudiante , String estado){

        Cola newCola = findByIdEstudiante(idEstudiante);

        newCola.setEstado(estado);
        return repository.save(newCola);
    }
}
