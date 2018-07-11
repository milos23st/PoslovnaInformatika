package com.poslovna.dto;

public class PoslovniPartnerDTO {
	
	private long id;
	
	private String Naziv;
	
	private String adresa;
	
    private String brojTelefona;

    private String email;

    private String brojRacuna;
	
	public PoslovniPartnerDTO(){
		
	}

	public PoslovniPartnerDTO(long id, String naziv, String adresa, String brojTelefona, String email,
			String brojRacuna) {
		super();
		this.id = id;
		Naziv = naziv;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.brojRacuna = brojRacuna;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	

}
