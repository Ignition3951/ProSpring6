package com.utk.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.utk.entity.Singer;

public interface SingerService {

	List<Singer> findAll();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Long id);

	Page<Singer> findAllByPage(Pageable pageable);

	List<Singer> findByFistNameAndLastName(String firstName, String lastName);

}
