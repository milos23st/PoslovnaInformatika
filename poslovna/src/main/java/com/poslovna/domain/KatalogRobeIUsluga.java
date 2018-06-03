package com.poslovna.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class KatalogRobeIUsluga {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nazivKataloga;
	
	private List<Proizvod> proizvodi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivKataloga() {
		return nazivKataloga;
	}

	public void setNazivKataloga(String nazivKataloga) {
		this.nazivKataloga = nazivKataloga;
	}

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}
	
	
	

}
