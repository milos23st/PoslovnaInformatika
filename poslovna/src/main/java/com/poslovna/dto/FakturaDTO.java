package com.poslovna.dto;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.domain.PoslovniPartner;
import com.poslovna.domain.Preduzece;

public class FakturaDTO {
	
	private Long id;
	
    private String brojFakture;
    
    private Long broj;
	
	private Date datumFakture;
	
	private Date datumValute;
	
	private double ukupanRabat;	
	
	private Date datumObracuna;
	
	private double bezPDV;
	
	private double ukupanPorez;
	
	private double ukupnoRobaIUsluge;

	private double iznosFakture;
	
	private String uplataNaRacun;
	
	private String pozivNaBroj;
	
	private Long poslovniPartnerId;
	
	private Long poslovnaGodinaId;
	
    private Long preduzeceId;
    
    public FakturaDTO() {}
    

	public FakturaDTO(Long id, String brojFakture, Long broj, Date datumFakture, Date datumValute, double ukupanRabat,
			Date datumObracuna, double bezPDV, double ukupanPorez, double ukupnoRobaIUsluge, double iznosFakture,
			String uplataNaRacun, String pozivNaBroj, Long poslovniPartnerId, Long poslovnaGodinaId, Long preduzeceId) {
		super();
		this.id = id;
		this.brojFakture = brojFakture;
		this.broj = broj;
		this.datumFakture = datumFakture;
		this.datumValute = datumValute;
		this.ukupanRabat = ukupanRabat;
		this.datumObracuna = datumObracuna;
		this.bezPDV = bezPDV;
		this.ukupanPorez = ukupanPorez;
		this.ukupnoRobaIUsluge = ukupnoRobaIUsluge;
		this.iznosFakture = iznosFakture;
		this.uplataNaRacun = uplataNaRacun;
		this.pozivNaBroj = pozivNaBroj;
		this.poslovniPartnerId = poslovniPartnerId;
		this.poslovnaGodinaId = poslovnaGodinaId;
		this.preduzeceId = preduzeceId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(String brojFakture) {
		this.brojFakture = brojFakture;
	}

	public Long getBroj() {
		return broj;
	}

	public void setBroj(Long broj) {
		this.broj = broj;
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

	public double getUkupanRabat() {
		return ukupanRabat;
	}

	public void setUkupanRabat(double ukupanRabat) {
		this.ukupanRabat = ukupanRabat;
	}

	public Date getDatumObracuna() {
		return datumObracuna;
	}

	public void setDatumObracuna(Date datumObracuna) {
		this.datumObracuna = datumObracuna;
	}

	public double getBezPDV() {
		return bezPDV;
	}

	public void setBezPDV(double bezPDV) {
		this.bezPDV = bezPDV;
	}

	public double getUkupanPorez() {
		return ukupanPorez;
	}

	public void setUkupanPorez(double ukupanPorez) {
		this.ukupanPorez = ukupanPorez;
	}

	public double getUkupnoRobaIUsluge() {
		return ukupnoRobaIUsluge;
	}

	public void setUkupnoRobaIUsluge(double ukupnoRobaIUsluge) {
		this.ukupnoRobaIUsluge = ukupnoRobaIUsluge;
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

	public Long getPoslovniPartnerId() {
		return poslovniPartnerId;
	}

	public void setPoslovniPartnerId(Long poslovniPartnerId) {
		this.poslovniPartnerId = poslovniPartnerId;
	}

	public Long getPoslovnaGodinaId() {
		return poslovnaGodinaId;
	}

	public void setPoslovnaGodinaId(Long poslovnaGodinaId) {
		this.poslovnaGodinaId = poslovnaGodinaId;
	}

	public Long getPreduzeceId() {
		return preduzeceId;
	}

	public void setPreduzeceId(Long preduzeceId) {
		this.preduzeceId = preduzeceId;
	}
    
    

}
