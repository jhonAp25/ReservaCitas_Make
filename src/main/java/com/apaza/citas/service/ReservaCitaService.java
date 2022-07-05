package com.apaza.citas.service;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Cita;
import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.repository.ReservaCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaCitaService {

    @Autowired
    private ReservaCitaRepository repository;

    @Autowired
    private CitaService citaService;

    @Autowired
    private AsistenciaService asistenciaService;

    public List<ReservaCita> listAll(){
        return repository.findAll();
    }

    public ReservaCita findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public ReservaCita findReservaCita(Long id){
        return repository.findAllByCita_Id(id);
    }

    public ReservaCita save(ReservaCita  reservaCita){

        Cita cita = reservaCita.getCita();
        citaService.updateEstado(cita);

        ReservaCita respCita = repository.save(reservaCita);

        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(respCita.getEstudiante());
        asistencia.setReservaCita(respCita);
        asistencia.setEstado("pendiente");
        asistenciaService.save(asistencia);


        return respCita;
    }
    public ReservaCita update(ReservaCita  cita){

        ReservaCita newCita = findbyId(cita.getId());

        //FALTA mas campos



        return repository.save(newCita);
    }
}
