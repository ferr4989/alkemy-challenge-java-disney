package com.nesper.alkemy.springboot.disney.controllers;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import com.nesper.alkemy.springboot.disney.models.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/movies")
    public List<ArrayList> listImageNameAndDate() {
        return movieService.listImageNameAndDate();
    }

    @GetMapping("/movies/listAll")
    public List<Movie> listAll() {
        return movieService.findAll();
    }

    @PostMapping("/createMovie")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody Movie movie) {
        this.movieService.save(movie);
        return movie;
    }

    @PostMapping("/updateMovie/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie update(@RequestBody Movie movie, @PathVariable Long id) {
        Movie currentMovie = this.movieService.findById(id);
        currentMovie.setImage(movie.getImage());
        currentMovie.setName(movie.getName());
        currentMovie.setCreateAt(movie.getCreateAt());
        currentMovie.setScore(movie.getScore());
        this.movieService.save(currentMovie);
        return currentMovie;
    }

    @GetMapping("/deleteMovie/{id}")
    public void delete(@PathVariable Long id) {
        Movie currentMovie = this.movieService.findById(id);
        this.movieService.delete(currentMovie);
    }

    @GetMapping("/movies/name={name}")
    public List<Movie> listByName(@PathVariable String name) {
        return movieService.findByName(name);
    }

}
