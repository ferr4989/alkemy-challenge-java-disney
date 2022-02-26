package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public interface IMovieService {

    List<Movie> findAll();

    void save(Movie cliente);

    Movie findById(Long id);

    void delete(Movie movie);

    List<ArrayList> listImageNameAndDate();

    List<Movie> findByName(String name);
}
