package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.GrupaProizvoda;

public interface GrupaProizvodaService {

	GrupaProizvoda add(GrupaProizvoda gp);
	
	List<GrupaProizvoda> findAll();
	
	boolean delete(Long id);
	
	GrupaProizvoda getById(Long id);
}
