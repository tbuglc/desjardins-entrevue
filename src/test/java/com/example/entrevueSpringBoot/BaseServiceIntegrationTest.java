package com.example.entrevueSpringBoot;

import com.tbuglc.film.entity.Acteur;
import com.tbuglc.film.entity.Film;
import com.tbuglc.film.service.BaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class BaseServiceIntegrationTest {

    @Autowired
    private BaseService<Film, Long> baseService;

    private Film film;
    private Film createdFilm;

    @BeforeEach
    void setUp() {
        List<Acteur> acteurs = Arrays.asList(new Acteur("Hello", "There"));

        film = new Film("some", "sme", acteurs);

        createdFilm = baseService.create(film);
    }

    @Test
    void create() {
        assertThat(createdFilm).isNotNull();
        assertThat(createdFilm.getId()).isEqualTo(1);
    }

    @Test
    void readAll() {
        List<Film> films = baseService.readAll();
        assertThat(films).isNotNull();
        assertThat(films.size()).isGreaterThan(0);
    }

    @Test
    void readById() {
        Film myFilm = baseService.readById(film.getId());
        assertThat(film.getId()).isEqualTo(myFilm.getId());
    }

    @Test
    void update() {
        film.setTitre("Updated");
        Film myfilm = baseService.update(film);

        assertThat(myfilm.getTitre()).isEqualTo("Updated");

    }

    @Test
    void remove() {
        baseService.remove(film);
        Film myfilm = baseService.readById(film.getId());

        assertThat(myfilm).isNull();
    }
}