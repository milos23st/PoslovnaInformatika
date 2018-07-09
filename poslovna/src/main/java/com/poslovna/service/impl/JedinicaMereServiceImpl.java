package com.poslovna.service.impl;

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

}
