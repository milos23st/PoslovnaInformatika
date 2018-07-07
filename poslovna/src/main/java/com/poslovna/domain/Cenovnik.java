package com.poslovna.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Cenovnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date datumVazenja;
	
	@OneToMany
	private List<StavkaCenovnika> stavke;
	
	@ManyToOne
    private  Valuta valuta;

    @ManyToOne
    private Preduzece preduzece;

    @OneToMany
    private List<StavkaCenovnika> stavkaCenovnikaList;


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

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public Preduzece getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public List<StavkaCenovnika> getStavkaCenovnikaList() {
		return stavkaCenovnikaList;
	}

	public void setStavkaCenovnikaList(List<StavkaCenovnika> stavkaCenovnikaList) {
		this.stavkaCenovnikaList = stavkaCenovnikaList;
	}

	public void setStavke(List<StavkaCenovnika> stavke) {
		this.stavke = stavke;
	}
	
	
	

}
