package com.apaza.citas.service;


import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.EstudianteRepository;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteService {


    private final EstudianteRepository repository;


    private final UserService userService;

    public EstudianteService(EstudianteRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<Estudiante> listAll(){
        return repository.findAll();
    }

    public List<Estudiante> findbyNombreAndApellido(String nombre, String apellido){
        return repository.findAllByNombreContainsOrApellidoContains(nombre, apellido);
    }

    public Estudiante findyDniEstudiante(String dni){
        return repository.findAllByDni(dni);
    }

    public Estudiante findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public Estudiante save(Estudiante  estudiante){

        UserDto userDto =  new UserDto();
        userDto.setEmail(estudiante.getCorreo());
        userDto.setNames(estudiante.getNombre() +" " + estudiante.getApellido());
        userDto.setSurnames(estudiante.getDni());

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

        if(estudiante.getCorreo() != null)
            newEstudiante.setCorreo(estudiante.getCorreo());

        if(estudiante.getTelefono() != null)
            newEstudiante.setTelefono(estudiante.getTelefono());

        if(estudiante.getFoto() != null)
            newEstudiante.setFoto(estudiante.getFoto());

        return repository.save(newEstudiante);
    }



}
