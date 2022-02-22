package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieDao extends CrudRepository<Movie, Long> {
}
