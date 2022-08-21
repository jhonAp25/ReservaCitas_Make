package com.apaza.citas.controller;


import com.apaza.citas.model.Especialidad;
import com.apaza.citas.service.EspecialidadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {


    private final EspecialidadService service;

    @Autowired
    public EspecialidadController(EspecialidadService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> busqueda(String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Especialidad> agregar(@RequestBody Especialidad especialidad){
        return new ResponseEntity<>(service.save(especialidad), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<Especialidad> actualizar(@RequestBody Especialidad especialidad){
        return new ResponseEntity<>(service.update(especialidad ), HttpStatus.OK);
    }


}



