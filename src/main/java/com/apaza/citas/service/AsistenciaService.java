package com.apaza.citas.service;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Carrera;
import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.repository.AsistenciaRepository;
import com.apaza.citas.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;



    public List<Asistencia> listAll(){
        return repository.findAll();
    }

    public Asistencia findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Asistencia save(Asistencia  asistencia){
        return repository.save(asistencia);
    }

    public Asistencia updateAsitencia(Asistencia  asistencia){

        Asistencia newAsistencia = findbyId(asistencia.getId());

        if(asistencia.getEstado() != null)
            newAsistencia.setEstado(asistencia.getEstado());



        return repository.save(newAsistencia);
    }

    public List<Asistencia> listAsistenciaEstudiante(Long id){
        return repository.findAllByEstudiante_Id(id);
    }

    public Asistencia updateEstad(Long id, String estado){
        Asistencia newAsistencia = repository.findAllByCita_Id(id);
        newAsistencia.setEstado(estado);
        return repository.save(newAsistencia);
    }
}
