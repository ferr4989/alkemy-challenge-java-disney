package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.entity.User;
import java.util.List;


public interface IUserService{
    List<User> findAll();
    User saveUser(User user);
}
