package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.PDV;

public interface PdvService {
	Long addPDV(PDV pdv);
	
	List<PDV> findAll();
}
