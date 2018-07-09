package com.poslovna.service;

import java.util.ArrayList;

import com.poslovna.domain.PoslovniPartner;


public interface PoslovniPartnerService {
	
	PoslovniPartner add(PoslovniPartner pp);

	PoslovniPartner getById(Long id);
	
	ArrayList<PoslovniPartner> findAll();

}
