package com.poslovna.dto;

import javax.persistence.ManyToOne;

import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.domain.JedinicaMere;
import com.poslovna.domain.Preduzece;

public class ProizvodDTO {
	
	private Long id;

	private String nazivProizvoda;

	private String opis;

	private Preduzece preduzece;
	
	private GrupaProizvoda grupaProizvod;
	
	private JedinicaMere jedinicaMere;
	
	public ProizvodDTO() {}

	
	public ProizvodDTO(Long id, String nazivProizvoda, String opis, Preduzece preduzece, GrupaProizvoda grupaProizvod,
			JedinicaMere jedinicaMere) {
		super();
		this.id = id;
		this.nazivProizvoda = nazivProizvoda;
		this.opis = opis;
		this.preduzece = preduzece;
		this.grupaProizvod = grupaProizvod;
		this.jedinicaMere = jedinicaMere;
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

	
	
	

}
