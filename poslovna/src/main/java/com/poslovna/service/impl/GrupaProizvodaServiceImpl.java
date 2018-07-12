package com.poslovna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.domain.PoslovniPartner;
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

	@Override
	public List<GrupaProizvoda> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public GrupaProizvoda getById(Long id) {
		Optional<GrupaProizvoda> grupa = repository.findById(id);
		return grupa.get();
	}
	
	

}
