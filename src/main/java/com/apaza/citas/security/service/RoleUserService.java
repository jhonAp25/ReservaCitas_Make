package com.apaza.citas.security.service;

import com.apaza.citas.security.model.RoleUser;
import com.apaza.citas.security.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleUserService {

    @Autowired
    private RoleUserRepository repository;

    public List<RoleUser> getAll(){
        return (List<RoleUser>) repository.findAll();
    }

    public RoleUser findRole(String id){
        return  repository.findByName(id);
    }

    public String create(RoleUser role){
        repository.save(role);
        return "Role \""+role.getName()+"\" Created.";
    }
}
