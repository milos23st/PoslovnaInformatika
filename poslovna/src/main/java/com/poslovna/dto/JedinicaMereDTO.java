package com.poslovna.dto;

public class JedinicaMereDTO {
	
	private Long id;

	private String naziv;

	private String skracenica;
	
	public JedinicaMereDTO() {}

	public JedinicaMereDTO(Long id, String naziv, String skracenica) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
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

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}
	

}
