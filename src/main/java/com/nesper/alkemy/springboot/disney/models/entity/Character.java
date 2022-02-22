package com.nesper.alkemy.springboot.disney.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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

    /* falta relacionar tablas de muchos a muchos
    @ManyToMany(mappedBy = "")
    private List<Movie> movies;
    */

    private static final long serialVersionUID = 1L;
}
