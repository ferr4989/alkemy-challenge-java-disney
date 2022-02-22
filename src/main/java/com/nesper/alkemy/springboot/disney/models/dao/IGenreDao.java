package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreDao extends CrudRepository<Genre, Long> {
}
