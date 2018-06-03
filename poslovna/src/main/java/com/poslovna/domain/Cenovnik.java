package com.poslovna.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cenovnik {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date datumVazenja;
	
	private List<StavkaCenovnika> stavke;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Date datumVazenja) {
		this.datumVazenja = datumVazenja;
	}

	public List<StavkaCenovnika> getStavke() {
		return stavke;
	}

	public void setStavka(List<StavkaCenovnika> stavke) {
		this.stavke = stavke;
	}
	
	

}
