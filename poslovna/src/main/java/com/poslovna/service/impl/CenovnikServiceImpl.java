package com.poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Cenovnik;
import com.poslovna.repository.CenovnikRepository;
import com.poslovna.service.CenovnikService;
@Service
public class CenovnikServiceImpl implements CenovnikService {
	
	@Autowired
	CenovnikRepository repository;

	@Override
	public Cenovnik add(Cenovnik c) {
		return repository.save(c);
	}

	@Override
	public List<Cenovnik> findAll() {
		return repository.findAll();
	}

	@Override
	public Cenovnik findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public boolean delete(Long id) {
		
		return false;
	}

}
