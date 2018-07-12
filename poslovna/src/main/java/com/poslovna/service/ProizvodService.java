package com.poslovna.service;

import java.util.ArrayList;

import com.poslovna.domain.Proizvod;


public interface ProizvodService {
	
	Proizvod add(Proizvod p);

	Proizvod getById(Long id);
	
	ArrayList<Proizvod> findAll();
	
	boolean delete(Long id);
}
