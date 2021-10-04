package com.example.entrevueSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import com.example.entrevueSpringBoot.entity.Acteur;
import com.example.entrevueSpringBoot.exception.BadRequest;
import com.example.entrevueSpringBoot.repository.ActeurRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActeurService extends BaseService<Acteur, Long> {
    @Autowired
    private ActeurRepository acteurRepository;

    public List<Acteur> addFilmActeur(List<Acteur> acteurs) {
        log.info("addFilmActeur - start");

        List<Acteur> acteursDuFilm = new ArrayList<>();

        if (acteurs == null) throw new BadRequest("Acteurs should not be null");

        for (Acteur acteur : acteurs) {
            Acteur acteurConnu;

            try {
                acteurConnu = acteurRepository.findByNom(acteur.getNom());
            } catch (Exception e) {
                acteurConnu = null;
            }

            if (acteurConnu == null) {
                log.info("addFilmActeur - Adding acteur ");
                acteurConnu = acteurRepository.save(acteur);
            }

            acteursDuFilm.add(acteurConnu);

        }

        log.info("addFilmActeur - end");
        return acteursDuFilm;
    }
}
