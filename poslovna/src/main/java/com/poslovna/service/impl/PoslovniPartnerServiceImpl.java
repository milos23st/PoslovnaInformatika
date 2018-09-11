package com.poslovna.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.PoslovniPartner;
import com.poslovna.repository.PoslovniPartnerRepository;
import com.poslovna.service.PoslovniPartnerService;
@Service
public class PoslovniPartnerServiceImpl implements PoslovniPartnerService{
	
	@Autowired
	PoslovniPartnerRepository repository;

	@Override
	public PoslovniPartner add(PoslovniPartner pp) {
		return repository.save(pp);
	}

	@Override
	public PoslovniPartner getById(Long id) {
		Optional<PoslovniPartner> poslovniPartner = repository.findById(id);
		return poslovniPartner.get();
	}

	@Override
	public ArrayList<PoslovniPartner> findAll() {
		return (ArrayList<PoslovniPartner>)repository.findAll();
	}

	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public ArrayList<PoslovniPartner> findAllKupac() {
		ArrayList<PoslovniPartner> p = (ArrayList<PoslovniPartner>) repository.findAll();
		ArrayList<PoslovniPartner> pp = new ArrayList<PoslovniPartner>();
		for(PoslovniPartner par: p) {
			if(par.getVrsta().equals(PoslovniPartner.VrstaPartnera.Kupac))
				pp.add(par);
		}
		return pp;
	}

}
