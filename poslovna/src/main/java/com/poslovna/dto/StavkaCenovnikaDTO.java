package com.poslovna.dto;

import com.poslovna.domain.Proizvod;

public class StavkaCenovnikaDTO {
	
	private double procenat;
	
	private Proizvod proizvod;
	
	private Long id;
	
	private double cena;
	
	public Long cenovnikId;
	
	public StavkaCenovnikaDTO() {
		super();
	}

	public double getProcenat() {
		return procenat;
	}

	public void setProcenat(double procenat) {
		this.procenat = procenat;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

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

	public Long getCenovnikId() {
		return cenovnikId;
	}

	public void setCenovnikId(Long cenovnikId) {
		this.cenovnikId = cenovnikId;
	}
	
	

}
