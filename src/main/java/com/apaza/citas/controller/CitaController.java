package com.apaza.citas.controller;


import com.apaza.citas.model.Meeting;
import com.apaza.citas.service.CitaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Api
@RestController
@RequestMapping("/cita")
public class CitaController {


    private final CitaService service;

    @Autowired
    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Meeting>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> busqueda(String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }


    @GetMapping("/{fecha}/{id}")
    public ResponseEntity<List<Meeting>> filtroFechaEspecialidad(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate  fecha, @PathVariable String id){

    //    if (service.findFechaEspecialidad(fecha,id).isEmpty())
    //      return new ResponseEntity<>("No Hay Citas Disponibles", HttpStatus.NO_CONTENT);
    //    }

        return new ResponseEntity<>(service.findFechaEspecialidad(fecha,id), HttpStatus.OK);
    }

    @GetMapping("/top/{idEspcd}")
    public ResponseEntity<List<Meeting>> topCita(@PathVariable String idEspcd){

        return new ResponseEntity<>(service.listaTop(idEspcd), HttpStatus.OK);
    }

    @GetMapping("/cita-disponible/{fecha}/{id}")
    public ResponseEntity<List<Meeting>> filtroFechaEspecialidadDisponibles(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate  fecha, @PathVariable String id){

        return new ResponseEntity<>(service.findFechaEspecialidadDisponible(fecha, id), HttpStatus.OK);
    }

    @GetMapping("/cita-especialista-fecha/{id}/{fecha}")
    public ResponseEntity<List<Meeting>> filtroFechaEspecialista(@PathVariable String id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate  fecha){

        return new ResponseEntity<>(service.findFechaEspecialista( id, fecha), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> agregar(@RequestBody Meeting cita){
        if (TRUE.equals(service.save(cita)))
            return new ResponseEntity<>("Agregado corectamente", HttpStatus.OK);
        return new ResponseEntity<>("Ya existe Cupos para ese Dia...", HttpStatus.BAD_REQUEST);


    }



    @PutMapping
    public ResponseEntity<Meeting> actualizar(@RequestBody Meeting cita){
        return new ResponseEntity<>(service.update(cita ), HttpStatus.OK);
    }
}
