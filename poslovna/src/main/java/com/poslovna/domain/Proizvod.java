package com.poslovna.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Proizvod {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nazivProizvoda;
	
	private List<StavkeFakture> stavke;
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}
	
	
	
	

}
