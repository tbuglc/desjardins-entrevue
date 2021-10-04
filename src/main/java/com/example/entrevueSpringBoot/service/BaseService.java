package com.example.entrevueSpringBoot.service;

import java.util.List;

import com.example.entrevueSpringBoot.controller.FilmController;
import com.example.entrevueSpringBoot.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T, ID> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FilmController.class);

	@Autowired
	private BaseRepository<T, ID> baseRepository;

	public T create(T data) {
		try {
			return baseRepository.save(data);
		} catch (Exception e) {
			// FIXME: Provide proper error handling
			LOGGER.error("Something went wrong while saving data", e);
			return null;
		}

	}

	public List<T> readAll() {
		try {
			return baseRepository.findAll();
		} catch (Exception e) {
			// FIXME: Provide proper error handling
			LOGGER.error("Something went wrong while reading all data", e);
			return null;
		}

	}

	public T readById(ID id) {

		try {
			return baseRepository.findById(id).get();
		} catch (Exception e) {
			// FIXME: Provide proper error handling
			LOGGER.error("Something went wrong while reading data by id", e);
			return null;
		}
	}

	public T update(T data) {
		try {
			return baseRepository.save(data);
		} catch (Exception e) {
			// FIXME: Provide proper error handling
			LOGGER.error("Something went wrong while updating data", e);
			return null;
		}
	}

	public void remove(T data) {
		try {
			baseRepository.delete(data);
		} catch (Exception e) {
			// FIXME: Provide proper error handling
			LOGGER.error("Something went wrong while deleting data", e);

		}

	}
}
