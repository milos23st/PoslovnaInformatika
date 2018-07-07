package com.poslovna.service;

import java.util.List;

import com.poslovna.domain.Narudzbenica;


public interface NarudzbenicaService {
	
	List<Narudzbenica> findAll();

    Narudzbenica findOne(Long id);

    void delete(Narudzbenica narudzbenica);

    Narudzbenica save(Narudzbenica narudzbenica);

}
