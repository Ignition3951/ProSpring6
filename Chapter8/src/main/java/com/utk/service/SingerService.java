package com.utk.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.utk.entity.Singer;

public interface SingerService {

	String ALL_SINGER_NATIVE_QUERY = "select ID, VERSION, FIRST_NAME, LAST_NAME, BIRTH_DATE from singer";

	Stream<Singer> findAll();

	Stream<Singer> findAllWithAlbum();

	Optional<Singer> findById(Long id);

	Optional<Singer> save(Singer singer);

	void delete(Singer singer);

	Stream<Singer> findAllWithNativeQuery();

}
