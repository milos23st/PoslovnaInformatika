package com.poslovna.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.IzlaznaFaktura;
import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;
import com.poslovna.repository.FakturaRepository;
import com.poslovna.service.FakturaService;



@Service
public class FakturaServiceImpl implements FakturaService {
	
	@Autowired
	FakturaRepository repository;

	@Override
	public ArrayList<IzlaznaFaktura> findAll() {
		return (ArrayList<IzlaznaFaktura>) repository.findAll();
	}

	@Override
	public IzlaznaFaktura add(IzlaznaFaktura novaFaktura) {
		return repository.save(novaFaktura);
	}

	@Override
	public IzlaznaFaktura getById(Long id) {
		Optional<IzlaznaFaktura> faktura = repository.findById(id);
		return faktura.get();
	}

	@Override
	public ArrayList<IzlaznaFaktura> getFakture(PoslovniPartner byId) {
		return (ArrayList<IzlaznaFaktura>) repository.findByPoslovniPartner(byId);
	}

	@Override
	public ArrayList<IzlaznaFaktura> getFaktureIzGodine(PoslovnaGodina poslovnaGodina) {
		return (ArrayList<IzlaznaFaktura>) repository.findByPoslovnaGodina(poslovnaGodina);
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
