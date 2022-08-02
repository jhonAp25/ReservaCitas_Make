package com.apaza.citas.controller;


import com.apaza.citas.model.Especialidad;
import com.apaza.citas.model.Especialista;
import com.apaza.citas.model.Estudiante;
import com.apaza.citas.service.EspecialistaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/especialista")
public class EspecialistaController {

    @Autowired
    private EspecialistaService service;

    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(@PathVariable Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/filtro/{dni}")
    public ResponseEntity<?> busquedaDni(@PathVariable String dni){
        return new ResponseEntity<>(service.findyDniEspecialista(dni), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Especialista especialista){
        return new ResponseEntity<>(service.save(especialista), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Especialista especialista){
        return new ResponseEntity<>(service.update(especialista ), HttpStatus.OK);
    }
}
