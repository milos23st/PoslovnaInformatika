package com.poslovna.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Proizvod;
import com.poslovna.repository.ProizvodRepository;
import com.poslovna.service.ProizvodService;

@Service
public class ProizvodServiceImpl implements ProizvodService{
	
	@Autowired
	ProizvodRepository repository;

	@Override
	public Proizvod add(Proizvod p) {
		return repository.save(p);
	}

	@Override
	public Proizvod getById(Long id) {
		Optional<Proizvod> proizvod = repository.findById(id);
		return proizvod.get();
	}

	@Override
	public ArrayList<Proizvod> findAll() {
		return (ArrayList<Proizvod>) repository.findAll();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
