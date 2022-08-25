package com.apaza.citas.service;


import com.apaza.citas.model.Student;
import com.apaza.citas.repository.StudentRepository;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {


    private final StudentRepository studentRepository;


    private final UserService userService;

    public StudentService(StudentRepository repository, UserService userService) {
        this.studentRepository = repository;
        this.userService = userService;
    }

    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public List<Student> findbyNombreAndApellido(String nombre, String apellido){
        return studentRepository.findAllByNombreContainsOrApellidoContains(nombre, apellido);
    }

    public Student findyDniEstudiante(String dni){
        return studentRepository.findAllByDni(dni);
    }

    public Student findbyId(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student save(Student  estudiante){

        UserDto userDto =  new UserDto();
        userDto.setEmail(estudiante.getEmail());
        userDto.setNames(estudiante.getName() +" " + estudiante.getSecondName());
        userDto.setSurnames(estudiante.getDni());

        userDto.setUsername(estudiante.getName());
        userDto.setPassword(estudiante.getSecondName().charAt(0) + estudiante.getDni());
        userDto.setRol("ESTUDIANTE");

        userService.newUser(userDto);


        return studentRepository.save(estudiante);
    }
    public Student update(Student  estudiante){

        Student newEstudiante = findbyId(estudiante.getId());

        if(estudiante.getName() != null)
            newEstudiante.setName(estudiante.getName());

        if(estudiante.getSecondName() != null)
            newEstudiante.setSecondName(estudiante.getSecondName());

        if(estudiante.getDataBirth() != null)
            newEstudiante.setDataBirth(estudiante.getDataBirth());

        if(estudiante.getEmail() != null)
            newEstudiante.setEmail(estudiante.getEmail());

        if(estudiante.getPhone() != null)
            newEstudiante.setPhone(estudiante.getPhone());

        if(estudiante.getPhoto() != null)
            newEstudiante.setPhoto(estudiante.getPhoto());

        return studentRepository.save(newEstudiante);
    }



}
