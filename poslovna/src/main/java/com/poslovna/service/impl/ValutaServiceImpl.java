package com.poslovna.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Valuta;
import com.poslovna.repository.ValutaRepository;
import com.poslovna.service.ValutaService;

@Service
public class ValutaServiceImpl implements ValutaService {
	
	@Autowired
	private ValutaRepository vRepository;

	@Override
	public Valuta add(Valuta va) {
		// TODO Auto-generated method stub
		return vRepository.save(va);
	}

	@Override
	public List<Valuta> findAll() {
		// TODO Auto-generated method stub
		return vRepository.findAll();
	}

	@Override
	public Valuta getById(Long id) {
		// TODO Auto-generated method stub	
		Optional<Valuta> val = vRepository.findById(id);
		return val.get();
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		vRepository.deleteById(id);
		return true;
	}
	
	

}
