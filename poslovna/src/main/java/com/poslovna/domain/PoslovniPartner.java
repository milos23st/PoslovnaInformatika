package com.poslovna.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PoslovniPartner {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private VrstaPartnera vrsta;
	
	private String Naziv;
	
	private String adresa;
	
    private String brojTelefona;

    private String email;

    private String brojRacuna;
    
    @ManyToOne
    private Preduzece preduzece;
	
	private enum VrstaPartnera {
		Kupac,
		Dobavljac,
		Oboje
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VrstaPartnera getVrsta() {
		return vrsta;
	}

	public void setVrsta(VrstaPartnera vrsta) {
		this.vrsta = vrsta;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public String getNaziv() {
		return Naziv;
	}

	public void setNaziv(String naziv) {
		Naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	

	
}
