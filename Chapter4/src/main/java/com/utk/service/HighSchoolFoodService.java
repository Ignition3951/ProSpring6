package com.utk.service;

import java.util.List;

import com.utk.model.Food;

public class HighSchoolFoodService implements FoodService {

	@Override
	public List<Food> provideLunchPack() {
		return List.of(new Food("Coke"), new Food("Hamburger"), new Food("Fries"));
	}

}
