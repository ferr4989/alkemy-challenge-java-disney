package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.entity.Genre;

import java.util.List;

public interface IGenreService {

    List<Genre> findAll();

    void save(Genre cliente);

    Genre findById(Long id);

    void delete(Genre cliente);
}
