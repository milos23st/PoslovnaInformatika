package com.poslovna.service.impl;

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

}
