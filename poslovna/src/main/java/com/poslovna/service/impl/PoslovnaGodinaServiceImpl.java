package com.poslovna.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.Preduzece;
import com.poslovna.repository.PoslovnaGodinaRepository;
import com.poslovna.service.PoslovnaGodinaService;

@Service
public class PoslovnaGodinaServiceImpl implements PoslovnaGodinaService{
	
	@Autowired
	PoslovnaGodinaRepository repository;

	@Override
	public PoslovnaGodina add(PoslovnaGodina pg) {
		return repository.save(pg);
	}

	@Override
	public PoslovnaGodina getNezakljucenaZaPreduzece(Preduzece preduzece) {
		List<PoslovnaGodina> poslovneGodine = repository.findByPreduzece(preduzece);
		for (PoslovnaGodina poslovnaGodina : poslovneGodine) 
		{
			if(!poslovnaGodina.isZakljucena())
			{
				return poslovnaGodina;
			}
		}
		return null;
	}

	@Override
	public PoslovnaGodina findOne(Long id) {
		Optional<PoslovnaGodina> opt = repository.findById(id);
		return opt.get();
	}

	@Override
	public ArrayList<PoslovnaGodina> findAll() {
		return (ArrayList<PoslovnaGodina>)repository.findAll();
	}
	
	

}
