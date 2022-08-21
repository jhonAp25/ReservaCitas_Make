package com.apaza.citas.controller;


import com.apaza.citas.model.Estudiante;
import com.apaza.citas.service.EstudianteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/estudiante")
@CrossOrigin("*")
public class EstudianteController {


    private final EstudianteService service;

    @Autowired
    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene todos los estudiantes")
    public ResponseEntity<List<Estudiante>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/filtroNombre")
    @ApiOperation(value = "Obtiene todos los estudiantes por Nombre y Apellidos")
    public ResponseEntity<List<Estudiante>> listadoNombreAndApellido(String datos){
        return new ResponseEntity<>(service.findbyNombreAndApellido(datos, datos), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> busqueda(@PathVariable  String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/filtro/{dni}")
    public ResponseEntity<Estudiante> busquedaDni(@PathVariable  String dni){
        return new ResponseEntity<>(service.findyDniEstudiante(dni), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estudiante> agregar(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(service.save(estudiante), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante){
        return new ResponseEntity<>(service.update(estudiante ), HttpStatus.OK);
    }
}
