package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.utk.service.AsyncService;
import com.utk.service.impl.AsyncServiceImpl;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Bean
	public AsyncService asyncService() {
		return new AsyncServiceImpl();
	}
}
