package com.nesper.alkemy.springboot.disney.controllers;

import com.nesper.alkemy.springboot.disney.models.entity.Genre;
import com.nesper.alkemy.springboot.disney.models.services.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GenreRestController {

    @Autowired
    private GenreServiceImpl genreService;

    @GetMapping("/genre")
    public List<Genre> listAll() {
        return genreService.findAll();
    }

    @PostMapping("/createGenre")
    public void create(@Valid @RequestBody Genre genre, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            this.genreService.save(genre);
            System.out.println("Genero creado con exito");
        }
    }

    @PostMapping("/updateGenre/{id}")
    public void update(@Valid @RequestBody Genre genre, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            Genre currentGenre = this.genreService.findById(id);
            currentGenre.setName(genre.getName());
            currentGenre.setImage(genre.getImage());
            currentGenre.setMovies(genre.getMovies());
            this.genreService.save(currentGenre);
            System.out.println("Género actualizado con exito");
        }
    }
    @GetMapping("/deleteGenre/{id}")
    public void delete(@PathVariable Long id) {
        Genre currentGenre = genreService.findById(id);
        genreService.delete(currentGenre);
    }
}
