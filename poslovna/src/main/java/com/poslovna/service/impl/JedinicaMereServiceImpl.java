package com.poslovna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.JedinicaMere;
import com.poslovna.repository.JedinicaMereRepository;
import com.poslovna.service.JedinicaMereService;

@Service
public class JedinicaMereServiceImpl implements JedinicaMereService{
	
	@Autowired
	private JedinicaMereRepository repository;

	@Override
	public JedinicaMere add(JedinicaMere jm) {
		return repository.save(jm);
	}

	@Override
	public List<JedinicaMere> findAll() {
		return repository.findAll();
	}

	@Override
	public JedinicaMere getById(Long id) {
		Optional<JedinicaMere> mera = repository.findById(id);
		return mera.get();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
