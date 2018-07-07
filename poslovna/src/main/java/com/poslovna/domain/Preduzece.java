package com.poslovna.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Preduzece {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nazivPreduzeca;
	
	@OneToMany
	private List<PoslovniPartner> partneri;
	
    private String pib;

    private String email;
    
    private String adresa;
    
    @OneToMany
    private List<PoslovniPartner> poslovniPartneri;

    @OneToMany
    private List<Cenovnik> cenovnici;

    @OneToMany
    private List<Proizvod> proizvodi;

    @OneToMany
    private List<IzlaznaFaktura> fakture;

    @OneToMany
    private List<PoslovnaGodina> poslovneGodine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public List<PoslovniPartner> getPartneri() {
		return partneri;
	}

	public void setPartneri(List<PoslovniPartner> partneri) {
		this.partneri = partneri;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public List<PoslovniPartner> getPoslovniPartneri() {
		return poslovniPartneri;
	}

	public void setPoslovniPartneri(List<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}

	public List<Cenovnik> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(List<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

	public List<IzlaznaFaktura> getFakture() {
		return fakture;
	}

	public void setFakture(List<IzlaznaFaktura> fakture) {
		this.fakture = fakture;
	}

	public List<PoslovnaGodina> getPoslovneGodine() {
		return poslovneGodine;
	}

	public void setPoslovneGodine(List<PoslovnaGodina> poslovneGodine) {
		this.poslovneGodine = poslovneGodine;
	}
    
    
    
    
	
	

}
