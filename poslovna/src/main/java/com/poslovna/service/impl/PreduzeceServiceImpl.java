package com.poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Preduzece;
import com.poslovna.repository.PreduzeceRepository;
import com.poslovna.service.PreduzeceService;

@Service
public class PreduzeceServiceImpl implements PreduzeceService {
	
	@Autowired
	private PreduzeceRepository repository;

	@Override
	public Preduzece add(Preduzece p) {
		return repository.save(p);
	}

	@Override
	public Preduzece getByName(String naziv) {
		List<Preduzece> preduzeca = repository.findByNazivPreduzeca(naziv);
		
		return preduzeca.get(0);
	}

	@Override
	public Preduzece getById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Preduzece> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
