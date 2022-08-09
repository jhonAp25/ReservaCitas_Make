package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.model.Cola;
import com.apaza.citas.model.Estudiante;
import com.apaza.citas.repository.CitaRepository;
import com.apaza.citas.repository.ColaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository repository;





    public List<Cita> listAll(){
        return repository.findAll();
    }

    public Cita findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cita> listaTop(Long idEspcd){
        return repository.findAllByEstadoAndEspecialista_Especialidad_IdOrderByFecha(true,idEspcd);
    }

    public List<Cita> findFechaEspecialidad(LocalDate fecha, Long id){
        return repository.findCitaByFechaAndEspecialista_Especialidad_Id(fecha,id);
    }

    public List<Cita> findFechaEspecialista( Long id,LocalDate fecha){
        return repository.findCitaByEspecialista_IdAndFechaAfter(id, fecha);
    }

    public List<Cita> findFechaEspecialidadDisponible( LocalDate fecha ,Long id){
        return repository.findCitaByFechaAndEspecialista_Especialidad_IdAndEstado(fecha,id, true);
    }



    public Cita save(Cita  cita){


        return repository.save(cita);
    }
    public Cita update(Cita  cita){

        Cita newCita = findbyId(cita.getId());

        //FALTA mas campos
        if(cita.getFecha()!= null)
            newCita.setFecha(cita.getFecha());



        return repository.save(newCita);
    }

    public Cita updateEstado(Cita  cita , boolean estado){

        Cita newCita = findbyId(cita.getId());
        newCita.setEstado(estado);

        return repository.save(newCita);
    }
}
