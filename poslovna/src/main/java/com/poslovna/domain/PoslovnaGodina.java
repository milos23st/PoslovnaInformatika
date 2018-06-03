package com.poslovna.domain;

import java.time.Year;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PoslovnaGodina {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Year godina;
	private boolean zakljucena;
	
	private List<IzlaznaFaktura> fakture;

}
