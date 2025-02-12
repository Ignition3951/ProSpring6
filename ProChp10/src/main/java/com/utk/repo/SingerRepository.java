package com.utk.repo;

import java.util.stream.Stream;

import org.springframework.data.repository.CrudRepository;

import com.utk.entity.Singer;

public interface SingerRepository extends CrudRepository<Singer, Long> {

	Stream<Singer> findByFistName(String firstName);

	Stream<Singer> findByFistNameAndLastName(String firstName, String lastName);
}
