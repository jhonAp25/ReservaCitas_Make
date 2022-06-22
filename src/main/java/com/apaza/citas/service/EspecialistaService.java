package com.apaza.citas.service;


import com.apaza.citas.model.Especialista;
import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaService {


    @Autowired
    private EspecialistaRepository repository;

    public List<Especialista> listAll(){
        return repository.findAll();
    }

    public Especialista findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Especialista save(Especialista  especialista){
        return repository.save(especialista);
    }
    public Especialista update(Especialista  especialista){

        Especialista newEspecialista = findbyId(especialista.getId());

        if(especialista.getNombre() != null)
            newEspecialista.setNombre(especialista.getNombre());

        if(especialista.getApellido() != null)
            newEspecialista.setApellido(especialista.getApellido());

        if(especialista.getDni() != null)
            newEspecialista.setDni(especialista.getDni());

        if(especialista.getFecNac() != null)
            newEspecialista.setFecNac(especialista.getFecNac());



        return repository.save(newEspecialista);
    }


}
