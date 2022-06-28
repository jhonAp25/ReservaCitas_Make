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

    public List<Estudiante> findbyNombreAndApellido(String nombre, String apellido){
        return repository.findAllByNombreContainsOrApellidoContains(nombre, apellido);
    }

    public Estudiante findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Estudiante save(Estudiante  estudiante){
        return repository.save(estudiante);
    }
    public Estudiante update(Estudiante  estudiante){

        Estudiante newEstudiante = findbyId(estudiante.getId());

        if(estudiante.getNombre() != null)
            newEstudiante.setNombre(estudiante.getNombre());

        if(estudiante.getApellido() != null)
            newEstudiante.setApellido(estudiante.getApellido());

        if(estudiante.getFecnac() != null)
            newEstudiante.setFecnac(estudiante.getFecnac());

        if(estudiante.getDni() != null)
            newEstudiante.setDni(estudiante.getDni());

        return repository.save(newEstudiante);
    }

}
