package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.Preduzece;

public interface PreduzeceService {
	
	Preduzece add(Preduzece p);

	Preduzece getByName(String string);
	
	Preduzece getById(Long id);
	
	List<Preduzece> findAll();
	
	boolean delete(Long id);

}
