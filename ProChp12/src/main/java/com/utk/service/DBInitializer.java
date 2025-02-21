package com.utk.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.utk.entity.Car;
import com.utk.repo.CarRepository;

import jakarta.annotation.PostConstruct;

@Service
public class DBInitializer {

	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	private final CarRepository carRepository;

	public DBInitializer(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@PostConstruct
	public void initDB() {
		logger.info("Starting database initialization...");
		var car = new Car();
		car.setLicensePlate("GRAVITY-0405");
		car.setManufacturer("Ford");
		car.setManufacturerDate(LocalDate.of(2006, 9, 12));
		carRepository.save(car);
		car = new Car();
		car.setLicensePlate("CLARITY-0432");
		car.setManufacturer("Toyota");
		car.setManufacturerDate(LocalDate.of(2003, 9, 9));
		carRepository.save(car);
		car = new Car();
		car.setLicensePlate("ROSIE-0402");
		car.setManufacturer("Toyota");
		car.setManufacturerDate(LocalDate.of(2017, 4, 16));
		carRepository.save(car);
		logger.info("Database initialization finished.");
	}

}
