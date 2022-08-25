package com.apaza.citas.repository;

import com.apaza.citas.model.Career;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface CareerRepository extends MongoRepository<Career, String> {
}
