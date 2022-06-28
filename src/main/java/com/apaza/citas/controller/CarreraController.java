package com.apaza.citas.controller;


import com.apaza.citas.model.Carrera;
import com.apaza.citas.model.Especialidad;
import com.apaza.citas.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrera   ")
public class CarreraController {

    @Autowired
    private CarreraService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Carrera carrera){
        return new ResponseEntity<>(service.save(carrera), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Carrera carrera){
        return new ResponseEntity<>(service.update(carrera ), HttpStatus.OK);
    }
}
