package com.example.entrevueSpringBoot.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends RuntimeException {
	public static HttpStatus status = HttpStatus.BAD_REQUEST;

	public BadRequest(String message) {
		super(message);
	}

}
