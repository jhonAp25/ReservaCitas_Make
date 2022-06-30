package com.apaza.citas.security.controller;

import com.apaza.citas.security.model.dto.JwtDto;
import com.apaza.citas.security.model.dto.LoginDto;
import com.apaza.citas.security.model.dto.UserDto;
import com.apaza.citas.security.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @GetMapping("/list-users")
    public ResponseEntity<?> listUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> create(@RequestBody UserDto user){
        if (service.existsByEmail(user.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Correo \""+user.getEmail()+"\" ya existe.");
        }
        if (service.existsByUsername(user.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Nombre de Usuario \""+user.getUsername()+"\" ya existe.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.newUser(user));
    }

    @PostMapping("/log-in")
    public ResponseEntity<JwtDto> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.Login(loginDto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.refresh(jwtDto));
    }
}
