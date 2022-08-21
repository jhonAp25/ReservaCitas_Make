package com.apaza.citas.controller;


import com.apaza.citas.model.Carrera;
import com.apaza.citas.service.CarreraService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/carrera")
public class CarreraController {

    private final CarreraService service;

    @Autowired
    public CarreraController(CarreraService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Carrera>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> busqueda(@PathVariable("id") String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carrera> agregar(@RequestBody Carrera carrera){
        return new ResponseEntity<>(service.save(carrera), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<Carrera> actualizar(@RequestBody Carrera carrera){
        return new ResponseEntity<>(service.update(carrera ), HttpStatus.OK);
    }
}
