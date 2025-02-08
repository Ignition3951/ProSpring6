package com.utk.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.utk.dao.SingerDao;
import com.utk.entity.Singer;

@org.springframework.transaction.annotation.Transactional(readOnly = true)
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Singer save(Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Singer singer) {
		// TODO Auto-generated method stub

	}

}
