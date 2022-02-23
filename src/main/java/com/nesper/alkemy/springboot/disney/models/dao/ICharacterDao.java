package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ICharacterDao extends JpaRepository<Character, Long> {

    @Query("select id, name, image from Character")
    List<ArrayList> listImageAndName();

    List<Character> findByName(String name);

    List<Character> findByAge(int age);
}
