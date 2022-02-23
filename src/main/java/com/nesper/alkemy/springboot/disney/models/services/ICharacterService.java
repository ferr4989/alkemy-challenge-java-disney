package com.nesper.alkemy.springboot.disney.models.services;

import com.nesper.alkemy.springboot.disney.models.entity.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ICharacterService {

    List<Character> findAll();

    void save(Character character);

    Character findById(Long id);

    void delete(Character cliente);

    List<ArrayList> listImageAndName();

    List<Character> findByName(String name);

    List<Character> findByAge(int age);
}
