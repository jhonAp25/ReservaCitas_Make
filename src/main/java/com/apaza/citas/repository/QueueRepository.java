package com.apaza.citas.repository;

import com.apaza.citas.model.Queue;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QueueRepository extends MongoRepository<Queue, String> {

    List<Queue> findAllByState (String estado);
    Queue findAllByStudentId(String id);
    Boolean existsAllByStudentId(String id);
}
