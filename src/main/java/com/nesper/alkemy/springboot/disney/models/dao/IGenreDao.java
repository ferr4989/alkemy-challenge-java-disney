package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreDao extends JpaRepository<Genre, Long> {
}
