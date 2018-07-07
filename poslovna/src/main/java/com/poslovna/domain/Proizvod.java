package com.poslovna.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Proizvod {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nazivProizvoda;
	
	private String opis;
	
	@ManyToOne
    private Preduzece preduzece;

    @ManyToOne
    private GrupaProizvoda grupaProizvod;

    @ManyToOne
    private JedinicaMere jedinicaMere;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivProizvoda() {
		return nazivProizvoda;
	}

	public void setNazivProizvoda(String nazivProizvoda) {
		this.nazivProizvoda = nazivProizvoda;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public GrupaProizvoda getGrupaProizvod() {
		return grupaProizvod;
	}

	public void setGrupaProizvod(GrupaProizvoda grupaProizvod) {
		this.grupaProizvod = grupaProizvod;
	}

	public JedinicaMere getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	
	
	
	
	
	

}
