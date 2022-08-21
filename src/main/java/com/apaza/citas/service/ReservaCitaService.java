package com.apaza.citas.service;


import com.apaza.citas.model.*;
import com.apaza.citas.repository.ReservaCitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaCitaService {


    private final ReservaCitaRepository repository;


    private final CitaService citaService;


    private final ColaService colaService;



    private final AsistenciaService asistenciaService;

    public ReservaCitaService(ReservaCitaRepository repository, CitaService citaService, ColaService colaService, AsistenciaService asistenciaService) {
        this.repository = repository;
        this.citaService = citaService;
        this.colaService = colaService;
        this.asistenciaService = asistenciaService;
    }

    public List<ReservaCita> listAll(){
        return repository.findAll();
    }

    public ReservaCita findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public ReservaCita findReservaCita(String id){
        return repository.findAllByCita_Id(id);
    }

    public ReservaCita save(ReservaCita  reservaCita){

        Cita cita = reservaCita.getCita();
        citaService.updateEstado(cita , false);

        ReservaCita respCita = repository.save(reservaCita);


        if (colaService.ColaExistenteEstudiante(reservaCita.getEstudiante().getId())){
            colaService.updateEstado(reservaCita.getEstudiante().getId() , "FINALIZADO");
        }

        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(respCita.getEstudiante());
        asistencia.setCita(cita);
        asistencia.setEstado("PENDIENTE");
        asistenciaService.save(asistencia);


        return respCita;
    }
    public ReservaCita update(ReservaCita  cita){

        ReservaCita newCita = findbyId(cita.getId());

        //FALTA mas campos

        return repository.save(newCita);
    }

    public List<ReservaCita> listReservaEstudiante(String id){
        return repository.findAllByEstudiante_Id(id);
    }

    public String  cancelarReserva(String  idCit){

        ReservaCita newReservaCita =  findReservaCita(idCit);
        repository.delete(newReservaCita);

        asistenciaService.updateEstad(idCit , "CANCELADO");
        citaService.updateEstado(newReservaCita.getCita() , true);



        return "Se cancelo la reserva existosamente!";
    }


}
