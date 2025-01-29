package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.utk.service.FoodService;
import com.utk.service.KinderGartenFoodService;

@Configuration
@Profile(value = "kindergarten")
public class KinderGartenConfig {

	@Bean
	public FoodService foodService() {
		return new KinderGartenFoodService();
	}
}
