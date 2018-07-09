package com.poslovna.dto;


import java.util.Date;
import java.util.List;



public class CenovnikDTO {
	
	private Date datum;
	
	private List<StavkaCenovnikaDTO> stavke;
	
	public CenovnikDTO() {
		super();
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<StavkaCenovnikaDTO> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaCenovnikaDTO> stavke) {
		this.stavke = stavke;
	}

}
