package com.utk.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.style.ToStringCreator;

import jakarta.annotation.PostConstruct;

public class Singer {

	private static Logger logger = LoggerFactory.getLogger(Singer.class);
	public static final String DEFAULT_NAME = "No Name";

	private String name;
	private int age;

	public void setName(String name) {
		logger.info("Calling setName for bean of type {}.", Singer.class);
		this.name = name;
	}

	public void setAge(int age) {
		logger.info("Calling setAge for bean of type {}.", Singer.class);
		this.age = age;
	}

	@PostConstruct
	public void init() throws Exception {
		logger.info("Initializing bean");
		if (name == null) {
			logger.info("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == 0) {
			throw new IllegalArgumentException("You must set the age property of any bean name : " + Singer.class);
		}
	}

	@Override
	public String toString() {
		return new ToStringCreator(this).append("name", name).append("age", age).toString();
	}

}
