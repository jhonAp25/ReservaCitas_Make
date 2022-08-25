package com.apaza.citas.service;


import com.apaza.citas.model.*;
import com.apaza.citas.repository.BookAppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAppointmentService {


    private final BookAppointmentRepository repository;


    private final MeetingService citaService;


    private final QueueService colaService;


    private final AttendanceService attendanceService;

    public BookAppointmentService(BookAppointmentRepository repository, MeetingService citaService, QueueService colaService, AttendanceService attendanceService) {
        this.repository = repository;
        this.citaService = citaService;
        this.colaService = colaService;
        this.attendanceService = attendanceService;
    }

    public List<BookAppointment> listAll() {
        return repository.findAll();
    }

    public BookAppointment findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public BookAppointment findBookAppointment(String id) {
        return repository.findAllByCitaId(id);
    }

    public BookAppointment save(BookAppointment reservaCita) {

        Meeting cita = reservaCita.getMeeting();
        citaService.updateEstado(cita, false);

        BookAppointment respCita = repository.save(reservaCita);


        if (colaService.queueStudentExist(reservaCita.getStudent().getId())) {
            colaService.updateEstado(reservaCita.getStudent().getId(), "FINALIZADO");
        }

        Attendance attendance = new Attendance();
        attendance.setStudent(respCita.getStudent());
        attendance.setMeeting(cita);
        attendance.setState("PENDIENTE");
        attendanceService.save(attendance);


        return respCita;
    }

    public BookAppointment update(BookAppointment cita) {

        BookAppointment newCita = findById(cita.getId());

        //FALTA mas campos

        return repository.save(newCita);
    }

    public List<BookAppointment> listReservaEstudiante(String id) {
        return repository.findAllByEstudianteId(id);
    }

    public String cancelarReserva(String idCit) {

        BookAppointment newReservaCita = findBookAppointment(idCit);
        repository.delete(newReservaCita);

        attendanceService.updateEstad(idCit, "CANCELADO");
        citaService.updateEstado(newReservaCita.getMeeting(), true);


        return "Se cancelo la reserva existosamente!";
    }


}
