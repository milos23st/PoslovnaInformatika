package com.poslovna.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class IzlaznaFaktura {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date datumFakture;	
	private Date datumValute;
	private Date datumObracuna;
	
	private double ukupnoRobaIUsluge;
	private double ukupanRabat;	
	private double ukupanPorez;
	private double iznosFakture;
	
	private String uplataNaRacun;
	private String pozivNaBroj;
	private StatusFakture statusFakture;
	
	private List<StavkeFakture> stavkeFakture;
	
	private enum StatusFakture {
		Obracunata,
		Poslata,
		Stornirana
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumFakture() {
		return datumFakture;
	}

	public void setDatumFakture(Date datumFakture) {
		this.datumFakture = datumFakture;
	}

	public Date getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}

	public Date getDatumObracuna() {
		return datumObracuna;
	}

	public void setDatumObracuna(Date datumObracuna) {
		this.datumObracuna = datumObracuna;
	}

	public double getUkupnoRobaIUsluge() {
		return ukupnoRobaIUsluge;
	}

	public void setUkupnoRobaIUsluge(double ukupnoRobaIUsluge) {
		this.ukupnoRobaIUsluge = ukupnoRobaIUsluge;
	}

	public double getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(double ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public double getUkupanPorez() {
		return ukupanPorez;
	}

	public void setUkupanPorez(double ukupanPorez) {
		this.ukupanPorez = ukupanPorez;
	}

	public double getIznosFakture() {
		return iznosFakture;
	}

	public void setIznosFakture(double iznosFakture) {
		this.iznosFakture = iznosFakture;
	}

	public String getUplataNaRacun() {
		return uplataNaRacun;
	}

	public void setUplataNaRacun(String uplataNaRacun) {
		this.uplataNaRacun = uplataNaRacun;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public StatusFakture getStatusFakture() {
		return statusFakture;
	}

	public void setStatusFakture(StatusFakture statusFakture) {
		this.statusFakture = statusFakture;
	}
	
	
	
	
	

}
