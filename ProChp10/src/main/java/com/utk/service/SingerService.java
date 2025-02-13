package com.utk.service;

import java.util.stream.Stream;

import com.utk.entity.Singer;

public interface SingerService {

	Stream<Singer> findAll();

	Stream<Singer> findByFirstName(String firstName);

	Stream<Singer> findByFirstNameAndLastName(String firstName, String lastName);

	Singer updateFirstName(String firstName, Long id);
}
