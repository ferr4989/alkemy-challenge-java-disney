package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.dao.IGenreDao;
import com.nesper.alkemy.springboot.disney.models.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IGenreServiceImpl implements IGenreService{

    @Autowired
    private IGenreDao genreDao;

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return (List<Genre>) genreDao.findAll();
    }

    @Override
    @Transactional
    public void save(Genre genre) { genreDao.save(genre); }

    @Override
    @Transactional(readOnly = true)
    public Genre findById(Long id) { return genreDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Genre genre) { genreDao.delete(genre); }
}
