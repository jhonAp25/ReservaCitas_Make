package com.apaza.citas.controller;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Cola;
import com.apaza.citas.service.ColaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Api
@RestController
@RequestMapping("/cola")
public class ColaController {

    @Autowired
    private ColaService service;


    @GetMapping
    public ResponseEntity<?> lista(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/espera")
    public ResponseEntity<?> colaEspera(){
        return new ResponseEntity<>(service.findColaEspera(), HttpStatus.OK);
    }




    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Cola cola){
        return new ResponseEntity<>(service.save(cola), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizarEstado(@PathVariable Long idEstudiante ,@PathVariable String estado ){
        return new ResponseEntity<>(service.updateEstado(idEstudiante, estado ), HttpStatus.OK);
    }


}
