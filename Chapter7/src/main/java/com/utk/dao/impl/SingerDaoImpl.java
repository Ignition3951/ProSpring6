package com.utk.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.utk.dao.SingerDao;
import com.utk.entity.Singer;

@org.springframework.transaction.annotation.Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

	private static Logger logger = LoggerFactory.getLogger(SingerDaoImpl.class);

	private final org.hibernate.SessionFactory sessionFactory;

	public SingerDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
	}

	@Override
	public List<Singer> findAllWithAlbum() {
		return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
	}

	@Override
	public Singer findById(Long id) {
		return (Singer) sessionFactory.getCurrentSession().getNamedQuery("Singer.findById").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public Singer save(Singer singer) {
		sessionFactory.getCurrentSession().saveOrUpdate(singer);
		logger.info("Singer saved with message id : {}", singer.getId());
		return singer;
	}

	@Override
	public void delete(Singer singer) {
		sessionFactory.getCurrentSession().delete(singer);
		logger.info("Singer deleted with id" + singer.getId());
	}

}
