package com.utk.config;

import java.time.LocalDate;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.util.LocalDatePropertyEditor;

@Configuration
public class CustomRegistrarConfig {

	@Bean
	public PropertyEditorRegistrar editorRegistrar() {
		return registry -> registry.registerCustomEditor(LocalDate.class, new LocalDatePropertyEditor());
	}

	@Bean
	public CustomEditorConfigurer customEditorConfigurer() {
		var cus = new CustomEditorConfigurer();
		var registrars = new PropertyEditorRegistrar[1];
		registrars[0] = editorRegistrar();
		cus.setPropertyEditorRegistrars(registrars);
		return cus;
	}
}
