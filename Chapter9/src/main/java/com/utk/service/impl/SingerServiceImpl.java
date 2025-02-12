package com.utk.service.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.utk.entity.Singer;
import com.utk.exception.TitleTooLongException;
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

	@Value("#{properties.get('BATCH_SIZE')}")
	private int batchSize;

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public Stream<Singer> findAll() {
		return entityManager.createNamedQuery("Singer.findAll", Singer.class).getResultList().stream();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Stream<Singer> findAllWithAlbum() {
		return entityManager.createNamedQuery("Singer.findAllWithAlbum", Singer.class).getResultList().stream();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	@Override
	public Optional<Singer> findById(Long id) {
		Singer singleResult = (Singer) entityManager.createNamedQuery("Singer.findById").setParameter("id", id)
				.getSingleResult();
		return Optional.ofNullable(singleResult);
	}

	@Override
	public Optional<Singer> save(Singer singer) {
		if (singer.getId() == null) {
			logger.info("Inserting new singer by using persist!!");
			entityManager.persist(singer);
			return Optional.of(singer);
		} else {
			entityManager.merge(singer);
			logger.info("Updating the singer record already present with id : {}", singer.getId());
			return Optional.of(singer);
		}

	}

	@Override
	public void delete(Singer singer) {
		Singer managedSingerInstance = entityManager.merge(singer);
		entityManager.remove(managedSingerInstance);
	}

	@Override
	public Stream<Singer> findAllWithNativeQuery() throws TitleTooLongException {
		logger.info("Inside findAllWithNativeQuery, the value of BATCH_SIZE is : {}", batchSize);
		throw new TitleTooLongException("Dummy exception which is not runtime!!!");
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = TitleTooLongException.class)
	public void saveSingerWithAlbums(Singer singer) throws TitleTooLongException {
		save(singer);
		findAllWithNativeQuery();
	}

}
