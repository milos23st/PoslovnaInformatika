package com.poslovna.domain;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Preduzece {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nazivPreduzeca;
	
	private List<PoslovniPartner> partneri;
	
	

}
