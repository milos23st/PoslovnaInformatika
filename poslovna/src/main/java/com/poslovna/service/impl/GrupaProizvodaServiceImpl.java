package com.poslovna.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.repository.GrupaProizvodaRepository;
import com.poslovna.service.GrupaProizvodaService;


@Service
public class GrupaProizvodaServiceImpl implements GrupaProizvodaService {
	
	@Autowired
	private GrupaProizvodaRepository repository;

	@Override
	public GrupaProizvoda add(GrupaProizvoda gp) {
		return repository.save(gp);
	}
	
	

}
