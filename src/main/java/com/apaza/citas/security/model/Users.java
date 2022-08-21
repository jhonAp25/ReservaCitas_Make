package com.apaza.citas.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {


    @Id
    private String id;

    private String names;
    private String surnames;
    private String email;


    private String username;
    private String password;


    private Set<RoleUser> roles;
}
