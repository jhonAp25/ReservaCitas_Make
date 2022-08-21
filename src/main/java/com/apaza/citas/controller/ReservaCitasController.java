package com.apaza.citas.controller;


import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.service.ReservaCitaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/reservaCita")
@CrossOrigin("*")
public class ReservaCitasController {


    private final ReservaCitaService service;

    @Autowired
    public ReservaCitasController(ReservaCitaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ReservaCita>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaCita> busqueda(String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @GetMapping("/fitroReserva/{id}")
    public ResponseEntity<ReservaCita> busquedaCita(@PathVariable String id){
            return new ResponseEntity<>(service.findReservaCita(id), HttpStatus.OK);
    }
    @GetMapping("/fitro-estudiante/{id}")
    public ResponseEntity<List<ReservaCita>> busquedaReservaEstudiante(@PathVariable String id){
        return new ResponseEntity<>(service.listReservaEstudiante(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ReservaCita> agregar(@RequestBody ReservaCita cita){
        return new ResponseEntity<>(service.save(cita), HttpStatus.OK);
    }



    @PutMapping
    public ResponseEntity<ReservaCita> actualizar(@RequestBody ReservaCita cita){
        return new ResponseEntity<>(service.update(cita ), HttpStatus.OK);
    }

    @DeleteMapping("/cancelar/{idCita}")
    public ResponseEntity<String> cancelarReserva(@PathVariable String idCita){
        return new ResponseEntity<>(service.cancelarReserva(idCita), HttpStatus.OK);
    }
}
