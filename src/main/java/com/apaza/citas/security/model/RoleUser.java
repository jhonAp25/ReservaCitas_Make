package com.apaza.citas.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "role_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleUser {
    @Id
    private String id;
    private String name;
}
