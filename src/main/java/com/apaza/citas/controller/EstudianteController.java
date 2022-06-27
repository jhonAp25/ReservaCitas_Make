package com.apaza.citas.controller;


import com.apaza.citas.model.Estudiante;
import com.apaza.citas.service.EstudianteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/estudiante")
@CrossOrigin("*")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @GetMapping
    @ApiOperation(value = "Obtiene todos los estudiantes")
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(service.save(estudiante), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(service.update(estudiante ), HttpStatus.OK);
    }
}
