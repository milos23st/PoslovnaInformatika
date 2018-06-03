package com.poslovna.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PoslovniPartner {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private VrstaPartnera vrsta;
	
	private List<IzlaznaFaktura> fakture;
	
	private enum VrstaPartnera {
		Kupac,
		Dobavljac,
		Oboje
		
	}

	
}
