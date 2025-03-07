package com.utk.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurableMessageProvider implements MessageProvider {

	private String message;

	public ConfigurableMessageProvider(@Value("Configurable Message") String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
