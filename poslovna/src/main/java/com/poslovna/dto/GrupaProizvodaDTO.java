package com.poslovna.dto;

import javax.persistence.Column;

import com.poslovna.domain.PDV;

public class GrupaProizvodaDTO {
	
	private Long id;

    private String naziv;

    private String opis;
    
    private PDV pdv;
    
    public GrupaProizvodaDTO() {}

	public GrupaProizvodaDTO(Long id, String naziv, String opis, PDV pdv) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.pdv = pdv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public PDV getPdv() {
		return pdv;
	}

	public void setPdv(PDV pdv) {
		this.pdv = pdv;
	}

	
    
	
   

}
