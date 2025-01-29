package com.utk.service;

import java.util.List;

import com.utk.model.Food;

public class KinderGartenFoodService implements FoodService{

	@Override
	public List<Food> provideLunchPack() {
		return List.of(new Food("Milk"), new Food("Biscuit"));
	}

}
