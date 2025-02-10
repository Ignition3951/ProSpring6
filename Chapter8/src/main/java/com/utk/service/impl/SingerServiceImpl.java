package com.utk.service.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.hibernate.cfg.NotYetImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.utk.entity.Singer;
import com.utk.service.SingerService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service("jpaSingerService")
@Repository
@Transactional
public class SingerServiceImpl implements SingerService {

	private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public Stream<Singer> findAll() {
		return entityManager.createNamedQuery("Singer.findAll", Singer.class).getResultList().stream();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public Stream<Singer> findAllWithAlbum() {
		throw new NotYetImplementedException("findAllWithAlbum");
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public Optional<Singer> findById(Long id) {
		throw new NotYetImplementedException("findById");
	}

	@Override
	public Optional<Singer> save(Singer singer) {
		throw new NotYetImplementedException("save");
	}

	@Override
	public void delete(Singer singer) {
		throw new NotYetImplementedException("delete");
	}

	@Override
	public Stream<Singer> findAllWithNativeQuery() {
		throw new NotYetImplementedException("findAllWithNativeQuery");
	}

}
