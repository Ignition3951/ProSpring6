package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.utk.service.FoodService;
import com.utk.service.HighSchoolFoodService;

@Configuration
@Profile(value = "highschool")
public class HighSchoolConfig {

	@Bean
	public FoodService foodService() {
		return new HighSchoolFoodService();
	}
}
