package com.apaza.citas.service;


import com.apaza.citas.model.Meeting;
import com.apaza.citas.repository.MeetingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MeetingService {


    private final MeetingRepository repository;

    public MeetingService(MeetingRepository repository) {
        this.repository = repository;
    }


    public List<Meeting> listAll(){
        return repository.findAll();
    }

    public Meeting findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public List<Meeting> listaTop(String idEspcd){
        return repository.findAllByStateAndSpecialistSpecialtyIdOrderByDate(true,idEspcd);
    }

    public List<Meeting> findFechaEspecialidad(LocalDate fecha, String id){
        return repository.findMeetingByDateAndSpecialistSpecialtyId(fecha,id);
    }

    public List<Meeting> findFechaEspecialista(String id, LocalDate fecha){
        return repository.findCitaBySpecialistIdAndDateAfter(id, fecha);
    }

    public List<Meeting> findFechaEspecialidadDisponible(LocalDate fecha , String id){
        return repository.findCitaByDateAndSpecialistSpecialtyIdAndState(fecha,id, true);
    }



    public Boolean save(Meeting cita){

        Long conteo = repository.countAllByDate(cita.getDate());
        if (conteo >= 5){
            return false;
        }
        repository.save(cita);
        return true;
    }
    public Meeting update(Meeting cita){

        Meeting newCita = findbyId(cita.getId());

        //FALTA mas campos
        if(cita.getDate()!= null)
            newCita.setDate(cita.getDate());



        return repository.save(newCita);
    }

    public Meeting updateEstado(Meeting cita , boolean estado){

        Meeting newCita = findbyId(cita.getId());
        newCita.setState(estado);

        return repository.save(newCita);
    }
}
