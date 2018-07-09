package com.poslovna.service;

import java.util.ArrayList;

import com.poslovna.domain.IzlaznaFaktura;
import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;


public interface FakturaService {
	
	ArrayList<IzlaznaFaktura> findAll();

	IzlaznaFaktura add(IzlaznaFaktura novaFaktura);

	IzlaznaFaktura getById(Long id);

	ArrayList<IzlaznaFaktura> getFakture(PoslovniPartner byId);

	ArrayList<IzlaznaFaktura> getFaktureIzGodine(PoslovnaGodina poslovnaGodina);

}
