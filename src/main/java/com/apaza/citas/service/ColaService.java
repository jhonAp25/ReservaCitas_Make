package com.apaza.citas.service;



import com.apaza.citas.model.Cola;
import com.apaza.citas.repository.ColaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaService {


    private final ColaRepository repository;

    public ColaService(ColaRepository repository) {
        this.repository = repository;
    }

    public List<Cola> listAll(){
        return repository.findAll();
    }

    public Cola findByIdEstudiante(String id){
        return repository.findAllByEstudiante_Id(id);
    }

    public Cola findById(String id){
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
    public Boolean ColaExistenteEstudiante(String id){
        return repository.existsAllByEstudiante_Id(id);
    }


    public Cola updateEstado(String idEstudiante , String estado){

        Cola newCola = findByIdEstudiante(idEstudiante);

        newCola.setEstado(estado);
        return repository.save(newCola);
    }
}
