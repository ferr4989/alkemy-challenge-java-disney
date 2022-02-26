package com.nesper.alkemy.springboot.disney.controllers;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import com.nesper.alkemy.springboot.disney.models.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void create(@Valid @RequestBody Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            this.movieService.save(movie);
            System.out.println("Película creada con exito");
        }
    }

    @PostMapping("/updateMovie/{id}")
    public void update(@Valid @RequestBody Movie movie, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            Movie currentMovie = this.movieService.findById(id);
            currentMovie.setImage(movie.getImage());
            currentMovie.setName(movie.getName());
            currentMovie.setCreateAt(movie.getCreateAt());
            currentMovie.setScore(movie.getScore());
            currentMovie.setCharacters(movie.getCharacters());
            this.movieService.save(currentMovie);
            System.out.println("Pelicula actualizada con exito");
        }
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
