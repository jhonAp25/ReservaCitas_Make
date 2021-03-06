package com.apaza.citas.controller;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Carrera;
import com.apaza.citas.service.AsistenciaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;


    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.save(asistencia), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.updateEstado(asistencia ), HttpStatus.OK);
    }
}
