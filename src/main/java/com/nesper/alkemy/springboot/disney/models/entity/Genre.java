package com.nesper.alkemy.springboot.disney.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="genres")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;

    /* falta relacionar tablas de uno a muchos
    @OneToMany(mappedBy = "")
    private List<Movie> movies;
    */

    private static final long serialVersionUID = 1L;

}
