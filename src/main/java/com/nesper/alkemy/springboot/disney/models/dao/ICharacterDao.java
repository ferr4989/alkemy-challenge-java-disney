package com.nesper.alkemy.springboot.disney.models.dao;

import com.nesper.alkemy.springboot.disney.models.entity.Character;
import org.springframework.data.repository.CrudRepository;

public interface ICharacterDao extends CrudRepository<Character, Long> {
}
