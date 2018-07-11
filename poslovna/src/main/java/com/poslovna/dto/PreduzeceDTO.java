package com.poslovna.dto;

public class PreduzeceDTO {
	
	private Long id;
	
	private String nazivPreduzeca;
	
    private String pib;

    private String email;
    
    private String adresa;
    
    public PreduzeceDTO() {}

	public PreduzeceDTO(Long id, String nazivPreduzeca, String pib, String email, String adresa) {
		super();
		this.id = id;
		this.nazivPreduzeca = nazivPreduzeca;
		this.pib = pib;
		this.email = email;
		this.adresa = adresa;
	}

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
    
    

}
