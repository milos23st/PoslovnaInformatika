package com.poslovna.dto;

import java.time.Year;

import com.poslovna.domain.Preduzece;

public class PoslovnaGodinaDTO {

	private Long id;
	
	private int godina;
	
	private boolean zakljucena;
	
    private Long preduzeceId;
    
    public PoslovnaGodinaDTO() {}
    
	public PoslovnaGodinaDTO(Long id, int godina, boolean zakljucena, Long preduzeceId) {
		super();
		this.id = id;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.preduzeceId = preduzeceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public boolean isZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(boolean zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Long getPreduzeceId() {
		return preduzeceId;
	}

	public void setPreduzeceId(Long preduzeceId) {
		this.preduzeceId = preduzeceId;
	}
    
    
    
    

}
