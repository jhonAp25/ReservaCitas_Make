package com.apaza.citas.security.repository;

import com.apaza.citas.security.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
