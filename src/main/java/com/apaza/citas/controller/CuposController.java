package com.apaza.citas.controller;



import com.apaza.citas.model.Cupos;
import com.apaza.citas.service.CuposService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api
@RestController
@RequestMapping("/cupos")
public class CuposController {

    @Autowired
    private CuposService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Cupos cupos){
        return new ResponseEntity<>(service.save(cupos), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Cupos cupos){
        return new ResponseEntity<>(service.update(cupos ), HttpStatus.OK);
    }
}
