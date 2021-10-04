package com.example.entrevueSpringBoot.controller;

import java.util.List;

import com.example.entrevueSpringBoot.entity.Acteur;
import com.example.entrevueSpringBoot.service.ActeurService;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.exception.BadRequest;
import com.example.entrevueSpringBoot.exception.NotFoundError;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {
	@Autowired
	private FilmService filmService;

	@Autowired
	private ActeurService acteurService;

	@PostMapping
	Film postFilem(@RequestBody Film film) {

		List<Acteur> acteurs = acteurService.addFilmActeur(film.getActeurs());

		film.setActeurs(acteurs);

		film = filmService.create(film);

		if (film == null)
			throw new BadRequest("Something went wrong while adding film");

		return film;

	}

	@GetMapping("/{id}")
	Film getFilmById(@PathVariable Long id) {

		Film film = filmService.readById(id);

		if (film == null)
			throw new NotFoundError("Could not find film with ID: " + id);

		return film;

	}

}
