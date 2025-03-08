package com.utk.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.utk.entity.Singer;
import com.utk.repo.SingerRepo;

@Service(value = "singerService")
@org.springframework.transaction.annotation.Transactional
public class SingerServiceImpl implements SingerService{

	private final SingerRepo repo;

	public SingerServiceImpl(SingerRepo repo) {
		this.repo = repo;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<Singer> findAll() {
		return repo.findAll();
	}

	@Override
	public Singer findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Singer save(Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Singer> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
