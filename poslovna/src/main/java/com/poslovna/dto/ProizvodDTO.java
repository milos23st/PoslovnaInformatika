package com.poslovna.dto;

import javax.persistence.ManyToOne;

import com.poslovna.domain.GrupaProizvoda;
import com.poslovna.domain.JedinicaMere;
import com.poslovna.domain.Preduzece;

public class ProizvodDTO {
	
	private Long id;

	private String nazivProizvoda;

	private String opis;

	private Long preduzeceId;

	private Long grupaProizvodId;

	private Long jedinicaMereId;
	
	public ProizvodDTO() {}

	public ProizvodDTO(Long id, String nazivProizvoda, String opis, Long preduzeceId, Long grupaProizvodId,
			Long jedinicaMereId) {
		super();
		this.id = id;
		this.nazivProizvoda = nazivProizvoda;
		this.opis = opis;
		this.preduzeceId = preduzeceId;
		this.grupaProizvodId = grupaProizvodId;
		this.jedinicaMereId = jedinicaMereId;
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

	public Long getPreduzeceId() {
		return preduzeceId;
	}

	public void setPreduzeceId(Long preduzeceId) {
		this.preduzeceId = preduzeceId;
	}

	public Long getGrupaProizvodId() {
		return grupaProizvodId;
	}

	public void setGrupaProizvodId(Long grupaProizvodId) {
		this.grupaProizvodId = grupaProizvodId;
	}

	public Long getJedinicaMereId() {
		return jedinicaMereId;
	}

	public void setJedinicaMereId(Long jedinicaMereId) {
		this.jedinicaMereId = jedinicaMereId;
	}
	
	

}
