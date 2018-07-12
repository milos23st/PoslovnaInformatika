package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.StavkeFakture;

public interface StavkaFaktureService {
	
	StavkeFakture add(StavkeFakture sf);
	
	StavkeFakture getById(Long id);
	
	List<StavkeFakture> findAll();
	
	boolean delete(Long id);

}
