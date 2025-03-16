package com.utk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = NotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView notFound(NotFoundException exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("problem", exception.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

	@ExceptionHandler(exception = NoHandlerFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView noHandler(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("problem", "Not supported : " + request.getRequestURI());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}
