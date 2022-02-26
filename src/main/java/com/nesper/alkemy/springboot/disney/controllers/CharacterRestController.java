package com.nesper.alkemy.springboot.disney.controllers;


import com.nesper.alkemy.springboot.disney.models.entity.Character;
import com.nesper.alkemy.springboot.disney.models.services.ICharacterService;
import com.nesper.alkemy.springboot.disney.models.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void create(@Valid @RequestBody Character character, BindingResult result) {
        if(result.hasErrors()){
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else{
            this.characterService.save(character);
            System.out.println("Personaje creado con exito");
        }
    }

    @PostMapping("/updateCharacter/{id}")
    public void update(@Valid @RequestBody Character character, BindingResult result, @PathVariable Long id) {

        if(result.hasErrors()){
            System.out.println("Revise los datos ingresados. Campos vacios o invalidos");
        } else {
            Character currentCharacter = this.characterService.findById(id);
            currentCharacter.setImage(character.getImage());
            currentCharacter.setName(character.getName());
            currentCharacter.setAge(character.getAge());
            currentCharacter.setWeight(character.getWeight());
            currentCharacter.setHistory(character.getHistory());
            currentCharacter.setMovies(character.getMovies());
            this.characterService.save(currentCharacter);
            System.out.println("Personaje actualizado con exito");
        }
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

}
