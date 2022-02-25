package com.nesper.alkemy.springboot.disney.controllers;


import com.nesper.alkemy.springboot.disney.models.entity.Character;
import com.nesper.alkemy.springboot.disney.models.services.ICharacterService;
import com.nesper.alkemy.springboot.disney.models.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterRestController {

    private UserServiceImpl userService;

    @Autowired
    private ICharacterService characterService;

    @GetMapping("/characters")
    public List<ArrayList> listImageAndName() {
        return characterService.listImageAndName();
    }

    @GetMapping("/characters/listAll")
    public List<Character> listAll() {
        return characterService.findAll();
    }

    @PostMapping("/createCharacter")
    public Character create(@RequestBody Character character) {
        this.characterService.save(character);
        return character;
    }

    @PostMapping("/updateCharacter/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Character update(@RequestBody Character character, @PathVariable Long id) {
        Character currentCharacter = this.characterService.findById(id);
        currentCharacter.setImage(character.getImage());
        currentCharacter.setName(character.getName());
        currentCharacter.setAge(character.getAge());
        currentCharacter.setWeight(character.getWeight());
        currentCharacter.setHistory(character.getHistory());
        this.characterService.save(currentCharacter);
        return currentCharacter;
    }

    @GetMapping("/deleteCharacter/{id}")
    public void delete(@PathVariable Long id) {
        Character currentCharacter = characterService.findById(id);
        characterService.delete(currentCharacter);
    }

    @GetMapping("/characters/name={name}")
    public List<Character> listByName(@PathVariable String name) {
        return characterService.findByName(name);
    }

    @GetMapping("/characters/age={age}")
    public List<Character> listByAge(@PathVariable int age) {
        return characterService.findByAge(age);
    }

    /* Implementar cuando esté la relación con movies
    @GetMapping("/characters/{movies}")
    public List<Character> listByMovie(@PathVariable Long idMovie) {
        return characterService.findById_Movie(idMovie);
    }
    */


}
