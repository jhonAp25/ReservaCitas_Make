package com.apaza.citas.controller;


import com.apaza.citas.model.Especialista;
import com.apaza.citas.service.EspecialistaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/especialista")
public class EspecialistaController {


    private final EspecialistaService service;

    @Autowired
    public EspecialistaController(EspecialistaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Especialista>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialista> busqueda(@PathVariable String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/filtro/{dni}")
    public ResponseEntity<Especialista> busquedaDni(@PathVariable String dni){
        return new ResponseEntity<>(service.findyDniEspecialista(dni), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Especialista> agregar(@RequestBody Especialista especialista){
        return new ResponseEntity<>(service.save(especialista), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Especialista> actualizar(@RequestBody Especialista especialista){
        return new ResponseEntity<>(service.update(especialista ), HttpStatus.OK);
    }
}
