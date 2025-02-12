package com.utk.service.impl;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.utk.entity.Singer;
import com.utk.repo.SingerRepository;
import com.utk.service.SingerService;

@Service("jpaSingerService")
public class SingerServiceImpl implements SingerService {

	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	private final SingerRepository singerRepository;

	public SingerServiceImpl(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	@Override
	public Stream<Singer> findAll() {
		return StreamSupport.stream(singerRepository.findAll().spliterator(), false);
	}

	@Override
	public Stream<Singer> findByFirstName(String firstName) {
		return StreamSupport.stream(singerRepository.findByFistName(firstName).spliterator(), false);
	}

	@Override
	public Stream<Singer> findByFirstNameAndLastName(String firstName, String lastName) {
		return StreamSupport.stream(singerRepository.findByFistNameAndLastName(firstName, lastName).spliterator(),
				false);
	}

}
