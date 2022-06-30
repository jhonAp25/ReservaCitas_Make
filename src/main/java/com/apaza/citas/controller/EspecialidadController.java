package com.apaza.citas.controller;


import com.apaza.citas.model.Especialidad;
import com.apaza.citas.model.Especialista;
import com.apaza.citas.service.EspecialidadService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Especialidad especialidad){
        return new ResponseEntity<>(service.save(especialidad), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Especialidad especialidad){
        return new ResponseEntity<>(service.update(especialidad ), HttpStatus.OK);
    }


}



