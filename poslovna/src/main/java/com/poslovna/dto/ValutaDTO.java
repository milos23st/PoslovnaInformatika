package com.poslovna.dto;

public class ValutaDTO {
	
	private Long Id;
	
	private String naziv;
	
	private String oznaka;

	public ValutaDTO() {

	}

	public ValutaDTO(Long id, String naziv, String oznaka) {
		super();
		Id = id;
		this.naziv = naziv;
		this.oznaka = oznaka;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	
	
	
	

}
