package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.model.NamedSinger;

@Configuration
public class AwareConfig {

	@Bean
	NamedSinger johnMayer() {
		return new NamedSinger();
	}
}
