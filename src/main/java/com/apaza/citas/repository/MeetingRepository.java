package com.apaza.citas.repository;

import com.apaza.citas.model.Meeting;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface MeetingRepository extends MongoRepository<Meeting, String> {

    List<Meeting> findMeetingByDateAndSpecialistSpecialtyId(LocalDate date, String id);
    List<Meeting> findAllByStateAndSpecialistSpecialtyIdOrderByDate(Boolean state, String id);
    List<Meeting> findCitaByDateAndSpecialistSpecialtyIdAndState(LocalDate date, String id, Boolean state);
    List<Meeting> findCitaBySpecialistIdAndDateAfter(String id, LocalDate date);
    Long countAllByDate(LocalDate date);


}
