package com.apaza.citas.service;


import com.apaza.citas.model.Specialist;
import com.apaza.citas.repository.SpecialistRepository;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaService {



    private final SpecialistRepository repository;


    private final UserService userService;

    public EspecialistaService(SpecialistRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<Specialist> listAll(){
        return repository.findAll();
    }

    public Specialist findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public Specialist findyDniEspecialista(String dni){
        return repository.findAllByDni(dni);
    }

    public Specialist save(Specialist  especialista){

        UserDto userDto =  new UserDto();
        userDto.setEmail(especialista.getEmail());
        userDto.setNames(especialista.getName()+" " + especialista.getSecondName());
        userDto.setSurnames(especialista.getDni());

        userDto.setUsername(especialista.getName());
        userDto.setPassword(especialista.getSecondName().charAt(0) + especialista.getDni());
        userDto.setRol("ESPECIALISTA");



        userService.newUser(userDto);

        return repository.save(especialista);
    }
    public Specialist update(Specialist  especialista){

        Specialist newSpecialist = findbyId(especialista.getId());

        if(especialista.getName() != null)
            newSpecialist.setName(especialista.getName());

        if(especialista.getSecondName() != null)
            newSpecialist.setSecondName(especialista.getSecondName());

        if(especialista.getDni() != null)
            newSpecialist.setDni(especialista.getDni());

        if(especialista.getDateBirth() != null)
            newSpecialist.setDateBirth(especialista.getDateBirth());

        if(especialista.getEmail() != null)
            newSpecialist.setEmail(especialista.getEmail());

        if(especialista.getPhone() != null)
            newSpecialist.setPhone(especialista.getPhone());



        return repository.save(newSpecialist);
    }


}
