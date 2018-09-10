package com.poslovna.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.Proizvod;
import com.poslovna.domain.StavkaCenovnika;
import com.poslovna.repository.StavkaCenovnikaRepository;
import com.poslovna.service.StavkaCenovnikaService;
@Service
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService {
	
	@Autowired
	StavkaCenovnikaRepository repository;

	@Override
	public StavkaCenovnika add(StavkaCenovnika sc) {
		return repository.save(sc);
	}

	@Override
	public double findCenaByCenovnikAndProizvod(Cenovnik cn, Proizvod proizvod) {
		return repository.findByCenovnikAndProizvod(cn, proizvod).get(0).getCena();
	}

	@Override
	public ArrayList<StavkaCenovnika> findByCenovnik(Cenovnik c) {
		return (ArrayList<StavkaCenovnika>)repository.findByCenovnik(c);
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		
		return true;
	}

}
