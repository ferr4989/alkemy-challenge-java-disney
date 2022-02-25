package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
