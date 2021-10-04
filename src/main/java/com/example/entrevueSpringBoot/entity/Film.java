package com.example.entrevueSpringBoot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import com.example.entrevueSpringBoot.entity.Acteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actuer", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "acteur_id"))
    private List<Acteur> acteurs = new ArrayList<>();

    public Film(String titre, String description, List<Acteur> acteurs) {
        this.titre = titre;
        this.description = description;
        this.acteurs = acteurs;
    }
}
