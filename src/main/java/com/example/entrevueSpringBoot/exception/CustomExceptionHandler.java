package com.example.entrevueSpringBoot.exception;

import java.time.ZonedDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(NotFoundError.class)
	public ResponseEntity<Object> handleNotFoundError(NotFoundError e) {

		ExceptionFormat exception = new ExceptionFormat(e.getMessage(), NotFoundError.status, ZonedDateTime.now());

		return new ResponseEntity<>(exception, NotFoundError.status);
	}

	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<Object> handleNotFoundError(BadRequest e) {

		ExceptionFormat exception = new ExceptionFormat(e.getMessage(), BadRequest.status, ZonedDateTime.now());

		return new ResponseEntity<>(exception, BadRequest.status);
	}


	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleNotFoundError(HttpRequestMethodNotSupportedException e) {

		ExceptionFormat exception = new ExceptionFormat(e.getMessage(), BadRequest.status, ZonedDateTime.now());

		return new ResponseEntity<>(exception, BadRequest.status);
	}
}
