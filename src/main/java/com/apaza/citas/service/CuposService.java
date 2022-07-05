package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Cupos;
import com.apaza.citas.repository.CuposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuposService {

    @Autowired
    private CuposRepository repository;

    public List<Cupos> listAll(){
        return repository.findAll();
    }

    public Cupos findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Cupos save(Cupos  cupos){
        return repository.save(cupos);
    }

    public Cupos update(Cupos  cupos){

        Cupos newCupos = findbyId(cupos.getId());


        if(cupos.getHoraInicio() != null)
            newCupos.setHoraInicio(cupos.getHoraInicio());

        if(cupos.getHoraFin() != null)
            newCupos.setHoraFin(cupos.getHoraFin());



        return repository.save(newCupos);
    }

    public Cupos updateEstado(Cupos  cupos){

        Cupos newCupos = findbyId(cupos.getId());


        newCupos.setEstado(false);

        return repository.save(newCupos);
    }
}
