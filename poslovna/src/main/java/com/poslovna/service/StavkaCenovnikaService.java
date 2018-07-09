package com.poslovna.service;

import java.util.ArrayList;

import com.poslovna.domain.Cenovnik;
import com.poslovna.domain.Proizvod;
import com.poslovna.domain.StavkaCenovnika;

public interface StavkaCenovnikaService {
	
	StavkaCenovnika add(StavkaCenovnika sc);

	double findCenaByCenovnikAndProizvod(Cenovnik cn, Proizvod proizvod);

	ArrayList<StavkaCenovnika> findByCenovnik(Cenovnik c);

}
