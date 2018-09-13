package com.poslovna.dto;


import java.util.Date;
import java.util.List;



public class CenovnikDTO {
	
	private Date datumVazenja;
	
	private List<StavkaCenovnikaDTO> stavke;
	
	public CenovnikDTO() {
		super();
	}

	public Date getDatumVazenja() {
		return datumVazenja;
	}

	public void setDatumVazenja(Date datum) {
		this.datumVazenja = datum;
	}

	public List<StavkaCenovnikaDTO> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaCenovnikaDTO> stavke) {
		this.stavke = stavke;
	}

}
