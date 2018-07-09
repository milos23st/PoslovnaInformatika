package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.Cenovnik;



public interface CenovnikService {
	
	Cenovnik add(Cenovnik c);
	
	List<Cenovnik> findAll();
	
	Cenovnik findOne(Long id);

}
