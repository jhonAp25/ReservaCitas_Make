package com.apaza.citas.repository;

import com.apaza.citas.model.Attendance;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {

    List<Attendance> findAllByStudentId(String id);
    List<Attendance> findAllByOrderByMeetingAsc();
    Attendance findAllByMeetingIdAndState(String id, String state);
    List<Attendance> findAllByMeetingSpecialistIdAndMeetingDate(String id, LocalDate date);



}
