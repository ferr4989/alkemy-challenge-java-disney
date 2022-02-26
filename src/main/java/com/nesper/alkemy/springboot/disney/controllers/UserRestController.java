package com.nesper.alkemy.springboot.disney.controllers;

import com.nesper.alkemy.springboot.disney.models.entity.User;
import com.nesper.alkemy.springboot.disney.models.services.UserServiceImpl;
import com.nesper.alkemy.springboot.disney.models.services.SendGridService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserRestController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SendGridService sendGridService;

    @GetMapping("/users")
    public List<User> listAll() {
        return userService.findAll();
    }

    @PostMapping("/auth/register")
    public void registerUser(@Valid @RequestBody User user, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            sendGridService.sendEmail(user.getEmail());
            this.userService.saveUser(user);
            System.out.println("Usuario registrado con exito");
        }
    }

    @GetMapping("/deleteUser/{id}")
    public void delete(@PathVariable Long id) {
        User currentUser = userService.findById(id);
        userService.delete(currentUser);
    }

}

