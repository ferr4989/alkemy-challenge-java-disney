package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface IMovieDao extends CrudRepository<Movie, Long> {

    @Query("select id, image, name, createAt from Movie")
    List<ArrayList> listImageNameAndDate();

    List<Movie> findByName(String name);

    @Query("select name, score from Movie order by name")
    List<ArrayList> findByOrderASC();

    @Query("select name, score, createAt from Movie order by name desc")
    List<ArrayList> findByOrderDESC();
}
