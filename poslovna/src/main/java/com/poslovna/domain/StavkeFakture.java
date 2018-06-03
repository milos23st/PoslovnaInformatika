package com.poslovna.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StavkeFakture {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long kolicina;
	
	private double rabat;
	
	private double jedinicnaCena;
	
	private double stopaPDV;
	
	private double osnovica;
	
	private double iznosPDV;
	
	private double ukupanIznos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKolicina() {
		return kolicina;
	}

	public void setKolicina(Long kolicina) {
		this.kolicina = kolicina;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public double getStopaPDV() {
		return stopaPDV;
	}

	public void setStopaPDV(double stopaPDV) {
		this.stopaPDV = stopaPDV;
	}

	public double getOsnovica() {
		return osnovica;
	}

	public void setOsnovica(double osnovica) {
		this.osnovica = osnovica;
	}

	public double getIznosPDV() {
		return iznosPDV;
	}

	public void setIznosPDV(double iznosPDV) {
		this.iznosPDV = iznosPDV;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}
	
	
	
	
	
	

}
