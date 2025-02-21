package com.utk.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utk.entity.Car;
import com.utk.repo.CarRepository;
import com.utk.service.CarService;

@Service("carService")
@Transactional
@Repository
public class CarServiceImpl implements CarService {

	public boolean done;

	final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

	private final CarRepository carRepository;

	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Stream<Car> findAll() {
		return StreamSupport.stream(carRepository.findAll().spliterator(), false);
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	@Scheduled(fixedDelay = 10000)
	public void updateCarAgeJob() {
		var cars = carRepository.findAll();
		var currentDate = LocalDate.now();
		logger.info("Update Job has started!!!!");

		cars.forEach(car -> {
			var period = Period.between(car.getManufacturerDate(), currentDate);
			int age = period.getYears();

			car.setAge(age);
			save(car);
			logger.info("Car details have been updated by the job!!!");
		});
		logger.info("Update Job has completed!!!!");
		done = true;
	}

	@Override
	public boolean isDone() {
		return done;
	}

}
