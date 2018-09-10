package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.Valuta;

public interface ValutaService {
	
	Valuta add(Valuta va);
	
	List<Valuta> findAll();
	
	Valuta getById(Long id);
	
	boolean delete(Long id);

}
