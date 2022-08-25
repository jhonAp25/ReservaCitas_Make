package com.apaza.citas.repository;

import com.apaza.citas.model.BookAppointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookAppointmentRepository extends MongoRepository<BookAppointment,String> {

    BookAppointment  findAllByCitaId(String id);
    List<BookAppointment> findAllByEstudianteId(String id);
}
