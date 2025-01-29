package com.utk.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.HighSchoolConfig;
import com.utk.config.KinderGartenConfig;
import com.utk.model.Food;
import com.utk.service.FoodService;

public class ProfileDemo {

	private static Logger logger = LoggerFactory.getLogger(ProfileDemo.class);

	public static void main(String[] args) {
		String profile = System.getProperty("profiles.active");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(profile);
		context.register(KinderGartenConfig.class,
				HighSchoolConfig.class);
		context.refresh();
		FoodService foodService = (FoodService) context.getBean("foodService");
		List<Food> lunchSets = foodService.provideLunchPack();
		lunchSets.forEach(food -> logger.info(food.getName()));

	}

}
