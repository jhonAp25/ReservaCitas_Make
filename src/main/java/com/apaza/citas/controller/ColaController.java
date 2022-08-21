package com.apaza.citas.controller;


import com.apaza.citas.model.Cola;
import com.apaza.citas.service.ColaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api
@RestController
@RequestMapping("/cola")
public class ColaController {

    private final ColaService service;

    @Autowired
    public ColaController(ColaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Cola>> lista(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cola> busqueda(String id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/espera")
    public ResponseEntity<List<Cola>> colaEspera(){
        return new ResponseEntity<>(service.findColaEspera(), HttpStatus.OK);
    }




    @PostMapping
    public ResponseEntity<Boolean> agregar(@RequestBody Cola cola){
        if (!service.save(cola))
            return new ResponseEntity<>(service.save(cola), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(service.save(cola), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<Cola> actualizarEstado(@PathVariable String idEstudiante ,@PathVariable String estado ){
        return new ResponseEntity<>(service.updateEstado(idEstudiante, estado ), HttpStatus.OK);
    }


}
