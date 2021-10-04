package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entity.Acteur;

public interface ActeurRepository extends BaseRepository<Acteur, Long> {
    Acteur findByNom(String nom);
}
