package com.apaza.citas.service;


import com.apaza.citas.model.Especialista;
import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.EspecialistaRepository;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaService {


    @Autowired
    private EspecialistaRepository repository;

    @Autowired
    private UserService userService;

    public List<Especialista> listAll(){
        return repository.findAll();
    }

    public Especialista findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Especialista findyDniEspecialista(String dni){
        return repository.findAllByDni(dni);
    }

    public Especialista save(Especialista  especialista){

        UserDto userDto =  new UserDto();
        userDto.setEmail(especialista.getCorreo());
        userDto.setNames(especialista.getNombre()+" " + especialista.getApellido());
        userDto.setSurnames(especialista.getDni());

        userDto.setUsername(especialista.getNombre());
        userDto.setPassword(especialista.getApellido().charAt(0) + especialista.getDni());
        userDto.setRol("ESPECIALISTA");



        userService.newUser(userDto);

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

        if(especialista.getFecnac() != null)
            newEspecialista.setFecnac(especialista.getFecnac());



        return repository.save(newEspecialista);
    }


}
