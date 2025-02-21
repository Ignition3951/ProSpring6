package com.utk.service;

import java.util.stream.Stream;

import com.utk.entity.Car;

public interface CarService {

	Stream<Car> findAll();

	Car save(Car car);

	void updateCarAgeJob();

	boolean isDone();
}
