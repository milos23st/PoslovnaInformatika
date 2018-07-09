package com.poslovna.dto;

import com.poslovna.domain.Proizvod;

public class StavkaCenovnikaDTO {
	
private double procenat;
	
	private Proizvod proizvod;
	
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

}
