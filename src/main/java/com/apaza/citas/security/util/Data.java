package com.apaza.citas.security.util;

import com.apaza.citas.security.model.RoleUser;
import com.apaza.citas.security.model.Users;
import com.apaza.citas.security.service.RoleUserService;
import com.apaza.citas.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Data {

    @Autowired
    private RoleUserService roleService;
//
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        Set<RoleUser> roles = new HashSet<>();

        if (roleService.getAll().isEmpty()){
            RoleUser rol1 = new RoleUser();
            rol1.setName("ADMIN");
            roleService.create(rol1);

            RoleUser rol2 = new RoleUser();
            rol2.setName("ESTUDIANTE");
            roleService.create(rol2);

            RoleUser rol3 = new RoleUser();
            rol3.setName("ESPECIALISTA");
            roleService.create(rol3);

            roles.add(rol1);
            roles.add(rol2);
            roles.add(rol3);

            System.out.println("Roles Created.");
        }
        else System.out.println("Roles already exist.");

        if (userService.getAll().isEmpty()){
            Users user = new Users();
            user.setNames("Alex Fernando");
            user.setSurnames("Justiniano De la cruz");
            user.setEmail("alex@gmail.com");
            user.setUsername("ALX99");
            user.setPassword("alex123");
            user.setRoles(roles);
            userService.create(user);

            System.out.println("Users Created.");
        }
        else System.out.println("Users already exist.");
    }
}
