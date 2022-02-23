package com.nesper.alkemy.springboot.disney.controllers;


import com.nesper.alkemy.springboot.disney.models.entity.User;
import com.nesper.alkemy.springboot.disney.models.services.UserService;
//import com.nesper.alkemy.springboot.disney.models.services.EmailService;


//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserRestController {

    @Autowired
    private UserService userService;
   // private final EmailService emailService;

    @GetMapping("/users")
    public List<User> listAll() {
        return userService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> guardarUsuario(@Valid @RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/guardar").toUriString());
//        emailService.sendEmail(usuario.getEmail());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    }

