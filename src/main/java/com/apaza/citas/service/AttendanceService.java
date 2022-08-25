package com.apaza.citas.service;


import com.apaza.citas.model.Attendance;
import com.apaza.citas.model.Specialty;
import com.apaza.citas.repository.AttendanceRepository;
import com.apaza.citas.util.ReportAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AttendanceService {


    private final AttendanceRepository repository;


    private final SpecialtyService specialtyService;

    @Autowired
    public AttendanceService(AttendanceRepository repository, SpecialtyService specialtyService) {
        this.repository = repository;
        this.specialtyService = specialtyService;
    }


    public List<Attendance> listAll(){
        return repository.findAllByOrderByMeetingAsc();
    }

    public Attendance findbyId(String id){
        return repository.findById(id).orElse(null);
    }

    public Attendance save(Attendance asistencia){
        return repository.save(asistencia);
    }

    public Attendance updateAttendance(Attendance asistencia){

        Attendance newAttendance = findbyId(asistencia.getId());

        if(asistencia.getState() != null)
            newAttendance.setState(asistencia.getState());



        return repository.save(newAttendance);
    }

    public List<Attendance> listAttendanceEstudiante(String id){
        return repository.findAllByStudentId(id);
    }


    public Attendance updateEstad(String id, String estado){
            Attendance newAsistencia = repository.findAllByMeetingIdAndState(id , "PENDIENTE");

        newAsistencia.setState(estado);
        return repository.save(newAsistencia);
    }

    public ByteArrayOutputStream getListAsitenciaPdf(LocalDate fecha, String idEspecialidad , String estado ) {
        List<Attendance> asistenciaList =  filterAll(fecha,idEspecialidad,estado);
        Specialty specialty = new Specialty();
        ReportAsistencia asistenciaPdf = new ReportAsistencia();
        if (idEspecialidad.isEmpty()){
            specialty = specialtyService.findbyId(idEspecialidad);
        }

        return asistenciaPdf.generateList(asistenciaList , fecha, specialty, estado );
    }

    public List<Attendance> listAsistenciaXespecialista(String id ){
        LocalDate ahora = LocalDate.now();
        return repository.findAllByMeetingSpecialistIdAndMeetingDate(id, ahora);
    }

    public List<Attendance> filterAll(LocalDate date, String idEspecialidad , String status ){
        return repository.findAll().stream().filter(asistencia -> {
            if (idEspecialidad != null) {
                return Objects.equals(asistencia.getMeeting().getSpecialist().getSpecialty().getId(), idEspecialidad);
            } else {
                return true;
            }
        }).filter(asistencia -> {
            if (date != null) {
                return asistencia.getMeeting().getDate().isEqual(date);
            } else {
                return true;
            }
        }).filter(asistencia -> {
            if (status != null) {
                return asistencia.getMeeting().equals(status);
            } else {
                return true;
            }
        }).collect(Collectors.toList());
    }

}
