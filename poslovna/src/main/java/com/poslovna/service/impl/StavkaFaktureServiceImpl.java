package com.poslovna.service.impl;

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

}
