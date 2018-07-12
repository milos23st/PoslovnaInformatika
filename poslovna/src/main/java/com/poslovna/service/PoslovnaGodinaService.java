package com.poslovna.service;

import java.util.ArrayList;

import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.Preduzece;



public interface PoslovnaGodinaService {
	
	PoslovnaGodina add(PoslovnaGodina pg);

	PoslovnaGodina getNezakljucenaZaPreduzece(Preduzece preduzece);

	PoslovnaGodina findOne(Long id);

	ArrayList<PoslovnaGodina> findAll();
	
	boolean delete(Long id);

}
