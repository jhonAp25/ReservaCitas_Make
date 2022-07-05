package com.apaza.citas.controller;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Cita;
import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.service.AsistenciaService;
import com.apaza.citas.service.ReservaCitaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/reservaCita")
@CrossOrigin("*")
public class ReservaCitasController {

    @Autowired
    private ReservaCitaService service;



    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busquedaCupos(@PathVariable Long id){
        return new ResponseEntity<>(service.findCitaPorCupos(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody ReservaCita cita){



        return new ResponseEntity<>(service.save(cita), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody ReservaCita cita){
        return new ResponseEntity<>(service.update(cita ), HttpStatus.OK);
    }
}
