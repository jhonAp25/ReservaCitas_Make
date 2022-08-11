package com.apaza.citas.controller;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Carrera;
import com.apaza.citas.service.AsistenciaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Api
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService service;


    @GetMapping
    public ResponseEntity<?> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busqueda(Long id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.save(asistencia), HttpStatus.OK);
    }

    @GetMapping("/fitro-estudiante/{id}")
    public ResponseEntity<?> busquedaReservaEstudiante(@PathVariable Long id){
        return new ResponseEntity<>(service.listAsistenciaEstudiante(id), HttpStatus.OK);
    }

    @GetMapping("/fitro-x-especialista/{id}")
    public ResponseEntity<?> busquedaXEspecialista(@PathVariable Long id){
        return new ResponseEntity<>(service.listAsistenciaXespecialista(id), HttpStatus.OK);
    }

    @GetMapping("/fitro-x-custom")
    public ResponseEntity<?> busquedaXCustom(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha , @RequestParam(required = false)  Long idEspecialista , @RequestParam(required = false)  String estado ){



        return new ResponseEntity<>(service.filtroAsistenciaCustom(fecha,idEspecialista,estado), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.updateAsitencia(asistencia ), HttpStatus.OK);
    }

    @PutMapping("/update-estado/{estado}/{idCita}")
    public ResponseEntity<?> actualizarEstado(@PathVariable String estado , @PathVariable Long idCita){
        return new ResponseEntity<>(service.updateEstad(idCita, estado ), HttpStatus.OK);
    }

    @GetMapping("/report/pdf")
    public ResponseEntity<byte[]> getListStudentsPdf(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha , @RequestParam(required = false)  Long idEspecialista , @RequestParam(required = false)  String estado ) {
        byte[] contents = service.getListAsitenciaPdf(fecha,idEspecialista,estado).toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "asistencia.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

}

