package com.nesper.alkemy.springboot.disney.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="characters")
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private int age;
    private float weight;
    private String history;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tbl_characters_movies", joinColumns = @JoinColumn(name="character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "movie_id"}))
    private List<Movie> movies;

    private static final long serialVersionUID = 1L;
}
