package com.apaza.citas.controller;


import com.apaza.citas.model.Career;
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
    public ResponseEntity<List<Career>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> busqueda(@PathVariable("id") String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Career> agregar(@RequestBody Career career){
        return new ResponseEntity<>(service.save(career), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<Career> actualizar(@RequestBody Career carrera){
        return new ResponseEntity<>(service.update(carrera ), HttpStatus.OK);
    }
}
