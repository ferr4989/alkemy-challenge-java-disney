package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.dao.ICharacterDao;
import com.nesper.alkemy.springboot.disney.models.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService{

    @Autowired
    private ICharacterDao characterDao;

    @Override
    @Transactional(readOnly = true)
    public List<Character> findAll() {
        return (List<Character>) characterDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArrayList> listImageAndName() { return characterDao.listImageAndName(); }

    @Override
    @Transactional(readOnly = true)
    public List<Character> findByName(String name) {
        return characterDao.findByName(name);
    }

    @Override
    public List<Character> findByAge(int age) {
        return characterDao.findByAge(age);
    }

    @Override
    @Transactional
    public void save(Character character) { characterDao.save(character); }

    @Override
    @Transactional(readOnly = true)
    public Character findById(Long id) {
        return characterDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Character character) { characterDao.delete(character); }

}
