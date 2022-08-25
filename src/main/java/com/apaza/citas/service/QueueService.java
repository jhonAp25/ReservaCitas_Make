package com.apaza.citas.service;



import com.apaza.citas.model.Queue;
import com.apaza.citas.repository.QueueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
public class QueueService {


    private final QueueRepository repository;

    public QueueService(QueueRepository repository) {
        this.repository = repository;
    }

    public List<Queue> listAll(){
        return repository.findAll();
    }

    public Queue findByIdEstudiante(String id){
        return repository.findAllByStudentId(id);
    }

    public Queue findById(String id){
        return repository.findById(id).orElse(null);
    }


    public List<Queue> findColaEspera(){
        return repository.findAllByState("ESPERA");
    }


    public Boolean save(Queue cola){
        if(TRUE.equals(queueStudentExist(cola.getStudent().getId())))
            return false;
        repository.save(cola);
        return true;
    }
    public Boolean queueStudentExist(String id){
        return repository.existsAllByStudentId(id);
    }


    public Queue updateEstado(String idEstudiante , String estado){

        Queue newCola = findByIdEstudiante(idEstudiante);

        newCola.setState(estado);
        return repository.save(newCola);
    }
}
