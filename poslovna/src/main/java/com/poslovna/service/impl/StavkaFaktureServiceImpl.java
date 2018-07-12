package com.poslovna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.StavkeFakture;
import com.poslovna.repository.StavkaFaktureRepository;
import com.poslovna.service.StavkaFaktureService;

@Service
public class StavkaFaktureServiceImpl implements StavkaFaktureService {
	
	@Autowired
	private StavkaFaktureRepository repository;

	@Override
	public StavkeFakture add(StavkeFakture sf) {
		return repository.save(sf);
	}

	@Override
	public StavkeFakture getById(Long id) {
		Optional<StavkeFakture> stavka = repository.findById(id);
		return stavka.get();
	}

	@Override
	public List<StavkeFakture> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
