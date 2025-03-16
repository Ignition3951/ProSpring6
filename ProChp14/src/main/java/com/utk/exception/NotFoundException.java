package com.utk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Requested item was not found")
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public <T> NotFoundException(Class<T> cls, Long id) {
		super(cls.getSimpleName() + " with id : " + id + " was not found!!!");
	}

}
