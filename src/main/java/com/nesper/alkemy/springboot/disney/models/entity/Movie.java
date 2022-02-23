package com.nesper.alkemy.springboot.disney.models.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createAt;
    @Min(value= 1, message = "Debe elegir una calificacion del 1 al 5")
    @Max(value= 5 ,message = "Debe elegir una calificacion del 1 al 5")
    private int score;

    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;

    private static final long serialVersionUID = 1L;
}
