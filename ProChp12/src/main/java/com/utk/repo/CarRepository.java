package com.utk.repo;

import org.springframework.data.repository.CrudRepository;

import com.utk.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
