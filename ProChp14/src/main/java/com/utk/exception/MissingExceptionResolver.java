package com.utk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MissingExceptionResolver extends SimpleMappingExceptionResolver {

	private static Logger LOGGER = LoggerFactory.getLogger(MissingExceptionResolver.class);

//	private int order = Ordered.HIGHEST_PRECEDENCE;

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if (ex instanceof NoHandlerFoundException) {
			LOGGER.info(">>> Inside doResolveException >>>");
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("problem", "URL not supported : " + request.getRequestURI());
			response.setStatus(HttpStatus.NOT_FOUND.value());
			LOGGER.info(">>> End doResolveException >>>");
			return modelAndView;
		}
		return null;
	}

//	@Override
//	public int getOrder() {
//		return this.order;
//	}
}
