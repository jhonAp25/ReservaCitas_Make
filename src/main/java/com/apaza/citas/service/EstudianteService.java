package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.EstudianteRepository;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private UserService userService;

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

        UserDto userDto =  new UserDto();
        userDto.setEmail(estudiante.getCorreo());
        userDto.setNames(estudiante.getNombre() +" " + estudiante.getApellido());
        userDto.setSurnames(estudiante.getNombre());

        userDto.setUsername(estudiante.getNombre());
        userDto.setPassword(estudiante.getApellido().charAt(0) + estudiante.getDni());
        userDto.setRol("ESTUDIANTE");

        userService.newUser(userDto);


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

    public Estudiante updateEstado(Estudiante  estudiante){

        Estudiante newEstudiante = findbyId(estudiante.getId());

        newEstudiante.setEstado("ocupado");



        return repository.save(newEstudiante);
    }

}
