package com.apaza.citas.controller;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Especialidad;
import com.apaza.citas.service.CitaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/cita")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Cita cita){
        return new ResponseEntity<>(service.save(cita), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Cita cita){
        return new ResponseEntity<>(service.update(cita ), HttpStatus.OK);
    }
}
