package com.poslovna.dto;

import com.poslovna.domain.Proizvod;

public class StavkaFaktureDTO {
	
	private Proizvod proizvod;
	
	private double cena;
	
	private double stopaPDV;
	
	private double pdv;
	
	private Long kolicina;
	
    private Long id;
	
	private double rabat;
	
	private double rabatProcenat;
	
	private double jedinicnaCena;
	
	private double osnovica;
	
	private double iznosPDV;
	
	private double ukupanIznos;
	
	private Long proizvodId;
	
	private Long fakturaId;
	
	public StavkaFaktureDTO() {
		super();
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getStopaPDV() {
		return stopaPDV;
	}

	public void setStopaPDV(double stopaPDV) {
		this.stopaPDV = stopaPDV;
	}

	public double getPdv() {
		return pdv;
	}

	public void setPdv(double pdv) {
		this.pdv = pdv;
	}

	public Long getKolicina() {
		return kolicina;
	}

	public void setKolicina(Long kolicina) {
		this.kolicina = kolicina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRabat() {
		return rabat;
	}

	public void setRabat(double rabat) {
		this.rabat = rabat;
	}

	public double getRabatProcenat() {
		return rabatProcenat;
	}

	public void setRabatProcenat(double rabatProcenat) {
		this.rabatProcenat = rabatProcenat;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
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

	public Long getProizvodId() {
		return proizvodId;
	}

	public void setProizvodId(Long proizvodId) {
		this.proizvodId = proizvodId;
	}

	public Long getFakturaId() {
		return fakturaId;
	}

	public void setFakturaId(Long fakturaId) {
		this.fakturaId = fakturaId;
	}
	
	

}
