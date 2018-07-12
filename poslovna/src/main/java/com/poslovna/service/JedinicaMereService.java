package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.JedinicaMere;

public interface JedinicaMereService {
	
	JedinicaMere add(JedinicaMere jm);
	
	List<JedinicaMere> findAll();
	
	JedinicaMere getById(Long id);
	
	boolean delete(Long id);

}
