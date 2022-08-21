package com.apaza.citas.service;


import com.apaza.citas.model.Cita;
import com.apaza.citas.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaService {


    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }


    public List<Cita> listAll(){
        return repository.findAll();
    }

    public Cita findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public List<Cita> listaTop(String idEspcd){
        return repository.findAllByEstadoAndEspecialista_Especialidad_IdOrderByFecha(true,idEspcd);
    }

    public List<Cita> findFechaEspecialidad(LocalDate fecha, String id){
        return repository.findCitaByFechaAndEspecialista_Especialidad_Id(fecha,id);
    }

    public List<Cita> findFechaEspecialista( String id,LocalDate fecha){
        return repository.findCitaByEspecialista_IdAndFechaAfter(id, fecha);
    }

    public List<Cita> findFechaEspecialidadDisponible( LocalDate fecha ,String id){
        return repository.findCitaByFechaAndEspecialista_Especialidad_IdAndEstado(fecha,id, true);
    }



    public Boolean save(Cita  cita){

        Long conteo = repository.countAllByFecha(cita.getFecha());
        if (conteo >= 5){
            return false;
        }
        repository.save(cita);
        return true;
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
