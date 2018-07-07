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
public class Narudzbenica {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private int redniBroj;
	 	
	 @Column
	 @Temporal(TemporalType.DATE)
	 private Date datumKreiranja;

	 @ManyToOne
	 private PoslovniPartner narucilac;

	 @ManyToOne
	 private PoslovniPartner isporucilac;

	 @OneToMany
	 private List<StavkaNarudzbenice> stavkeNarudzbenice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public PoslovniPartner getNarucilac() {
		return narucilac;
	}

	public void setNarucilac(PoslovniPartner narucilac) {
		this.narucilac = narucilac;
	}

	public PoslovniPartner getIsporucilac() {
		return isporucilac;
	}

	public void setIsporucilac(PoslovniPartner isporucilac) {
		this.isporucilac = isporucilac;
	}

	public List<StavkaNarudzbenice> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(List<StavkaNarudzbenice> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}

	
	 
	 

}
