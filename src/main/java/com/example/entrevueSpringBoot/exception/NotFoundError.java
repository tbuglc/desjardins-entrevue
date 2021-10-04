package com.example.entrevueSpringBoot.exception;

import org.springframework.http.HttpStatus;

public class NotFoundError extends RuntimeException {
	public static HttpStatus status = HttpStatus.NOT_FOUND;

	public NotFoundError(String message) {
		super(message);
	}

}
