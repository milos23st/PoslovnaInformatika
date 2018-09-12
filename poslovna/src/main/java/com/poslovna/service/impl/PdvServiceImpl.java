package com.poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.PDV;
import com.poslovna.repository.PdvRepository;
import com.poslovna.service.PdvService;

@Service
public class PdvServiceImpl implements PdvService{

	@Autowired
	private PdvRepository pdvRepository;
	@Override
	public Long addPDV(PDV pdv) {
		return pdvRepository.save(pdv).getId();
	}
	@Override
	public List<PDV> findAll() {
		// TODO Auto-generated method stub
		return pdvRepository.findAll();
	}

}
