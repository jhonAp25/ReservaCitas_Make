package com.apaza.citas.service;


import com.apaza.citas.model.Asistencia;
import com.apaza.citas.model.Carrera;
import com.apaza.citas.model.Especialidad;
import com.apaza.citas.model.ReservaCita;
import com.apaza.citas.repository.AsistenciaRepository;
import com.apaza.citas.repository.CarreraRepository;
import com.apaza.citas.util.ReportAsistencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository repository;

    @Autowired
    private EspecialidadService especialidadService;



    public List<Asistencia> listAll(){
        return repository.findAllByOrderByCitaAsc();
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
            Asistencia newAsistencia = repository.findAllByCita_IdAndEstado(id , "PENDIENTE");

        newAsistencia.setEstado(estado);
        return repository.save(newAsistencia);
    }

    public ByteArrayOutputStream getListAsitenciaPdf(LocalDate fecha, Long idEspecialidad , String estado ) {
        List<Asistencia> asistenciaList =  filterAll(fecha,idEspecialidad,estado);
        Especialidad especialidad = new Especialidad();
        ReportAsistencia asistenciaPdf = new ReportAsistencia();
        if (idEspecialidad != null){
            especialidad = especialidadService.findbyId(idEspecialidad);
        }

        return asistenciaPdf.generateList(asistenciaList , fecha, especialidad, estado );
    }

    public List<Asistencia> listAsistenciaXespecialista(Long id ){
        LocalDate ahora = LocalDate.now();
        return repository.findAllByCita_Especialista_IdAndCita_Fecha(id, ahora);
    }

    public List<Asistencia> filterAll(LocalDate date, Long idEspecialidad , String status ){
        return repository.findAll().stream().filter(asistencia -> {
            if (idEspecialidad != null) {
                return Objects.equals(asistencia.getCita().getEspecialista().getEspecialidad().getId(), idEspecialidad);
            } else {
                return true;
            }
        }).filter(asistencia -> {
            if (date != null) {
                return asistencia.getCita().getFecha().isEqual(date);
            } else {
                return true;
            }
        }).filter(asistencia -> {
            if (status != null) {
                return asistencia.getEstado().equals(status);
            } else {
                return true;
            }
        }).collect(Collectors.toList());
    }

}
