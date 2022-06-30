package com.apaza.citas.security.repository;

import com.apaza.citas.security.model.RoleUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUserRepository extends CrudRepository<RoleUser, Integer> {
    RoleUser findByName(String name);
}
