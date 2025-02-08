package com.utk.dao;

import java.util.List;

import com.utk.entity.Singer;

public interface SingerDao {

	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);
}
