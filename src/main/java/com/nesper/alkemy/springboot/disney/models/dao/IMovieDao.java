package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface IMovieDao extends JpaRepository<Movie, Long> {

    @Query("select id, image, name, createAt from Movie")
    List<ArrayList> listImageNameAndDate();

    List<Movie> findByName(String name);
}
