package com.poslovna.domain;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class IzlaznaFaktura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String brojFakture;
    
    private Long broj;
	
	@Temporal(TemporalType.DATE)
	private Date datumFakture;
	
	@Temporal(TemporalType.DATE)
	private Date datumValute;
	
	private double ukupanRabat;	
	
	private Date datumObracuna;
	
	private double bezPDV;
	
	private double ukupanPorez;
	
	private double ukupnoRobaIUsluge;

	private double iznosFakture;
	
	private String uplataNaRacun;
	
	private String pozivNaBroj;
	
	private StatusFakture statusFakture;
	
	@ManyToOne
	private PoslovniPartner poslovniPartner;
	
	@ManyToOne
	private PoslovnaGodina poslovnaGodina;

    @ManyToOne
    private Preduzece preduzece;
	
	private enum StatusFakture {
		Obracunata,
		Poslata,
		Stornirana
	}
	

	public String getBrojFakture() {
		return brojFakture;
	}

	public void setBrojFakture(String brojFakture) {
		this.brojFakture = brojFakture;
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

	public Long getBroj() {
		return broj;
	}

	public void setBroj(Long broj) {
		this.broj = broj;
	}

	public double getBezPDV() {
		return bezPDV;
	}

	public void setBezPDV(double bezPDV) {
		this.bezPDV = bezPDV;
	}

	public PoslovniPartner getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartner poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}
	
	
	

}
