package com.nesper.alkemy.springboot.disney.controllers;

import com.nesper.alkemy.springboot.disney.models.entity.User;
import com.nesper.alkemy.springboot.disney.models.services.UserServiceImpl;
import com.nesper.alkemy.springboot.disney.models.services.SendGridService;


//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserRestController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SendGridService sendGridService;

    @GetMapping("/users")
    public List<User> listAll() {
        return userService.findAll();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) throws IOException {
        sendGridService.sendEmail(user.getEmail());
        this.userService.saveUser(user);
        return user;
    }

}

