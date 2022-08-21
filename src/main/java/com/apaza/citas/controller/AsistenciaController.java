package com.apaza.citas.controller;


import com.apaza.citas.model.Asistencia;
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
import java.util.List;

@Api
@RestController
@RequestMapping("/asistencia")
public class AsistenciaController {


    private final AsistenciaService service;

    @Autowired
    public AsistenciaController(AsistenciaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Asistencia>> listado(){
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> busqueda(String id){
        return new ResponseEntity<>(service.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Asistencia> agregar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.save(asistencia), HttpStatus.OK);
    }

    @GetMapping("/fitro-estudiante/{id}")
    public ResponseEntity<List<Asistencia>> busquedaReservaEstudiante(@PathVariable String id){
        return new ResponseEntity<>(service.listAsistenciaEstudiante(id), HttpStatus.OK);
    }

    @GetMapping("/fitro-x-especialista/{id}")
    public ResponseEntity<List<Asistencia>> busquedaXEspecialista(@PathVariable String id){
        return new ResponseEntity<>(service.listAsistenciaXespecialista(id), HttpStatus.OK);
    }

    @GetMapping("/fitro-x-custom")
    public ResponseEntity<List<Asistencia>> busquedaXCustom(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha , @RequestParam(required = false)  String idEspecialista , @RequestParam(required = false)  String estado ){



        return new ResponseEntity<>(service.filterAll(fecha,idEspecialista,estado), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Asistencia> actualizar(@RequestBody Asistencia asistencia){
        return new ResponseEntity<>(service.updateAsitencia(asistencia ), HttpStatus.OK);
    }

    @PutMapping("/update-estado/{estado}/{idCita}")
    public ResponseEntity<Asistencia> actualizarEstado(@PathVariable String estado , @PathVariable String idCita){
        return new ResponseEntity<>(service.updateEstad(idCita, estado ), HttpStatus.OK);
    }

    @GetMapping("/report/pdf")
    public ResponseEntity<byte[]> getListStudentsPdf(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha , @RequestParam(required = false)  String idEspecialista , @RequestParam(required = false)  String estado ) {
        byte[] contents = service.getListAsitenciaPdf(fecha,idEspecialista,estado).toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "asistencia.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }

}

