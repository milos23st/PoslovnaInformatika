package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.Cenovnik;



public interface CenovnikService {
	
	Cenovnik add(Cenovnik c);
	
	List<Cenovnik> findAll();
	
	Cenovnik findOne(Long id);
	
	boolean delete(Long id);
	
	Cenovnik findNewest();

	Cenovnik findActive(long currentTimeMillis);
	
	List<Cenovnik> findFuture(long currentTimeMillis);

}
