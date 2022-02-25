package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.dao.IMovieDao;
import com.nesper.alkemy.springboot.disney.models.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService{

    @Autowired
    private IMovieDao movieDao;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return (List<Movie>) movieDao.findAll();
    }

    @Override
    @Transactional
    public void save(Movie movie) { movieDao.save(movie); }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Movie movie) { movieDao.delete(movie); }

    @Override
    @Transactional(readOnly = true)
    public List<ArrayList> listImageNameAndDate() {
        return movieDao.listImageNameAndDate();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findByName(String name) {
        return movieDao.findByName(name);
    }


}
