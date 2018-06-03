package com.poslovna.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StavkaCenovnika {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private double cena;
	
	private Proizvod proizvod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
	

}
