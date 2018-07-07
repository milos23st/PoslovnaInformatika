package com.poslovna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poslovna.domain.Narudzbenica;
import com.poslovna.repository.NarudzbenicaRepository;
import com.poslovna.service.NarudzbenicaService;

@Service
public class NarudzbenicaServiceImpl implements NarudzbenicaService{
	
	@Autowired
    private NarudzbenicaRepository narudzbenicaRepository;

    @Override
    public List<Narudzbenica> findAll() {
        return narudzbenicaRepository.findAll();
    }

    @Override
    public Narudzbenica findOne(Long id) {
        return narudzbenicaRepository.getOne(id);
    }

    @Override
    public void delete(Narudzbenica narudzbenica) {
        narudzbenicaRepository.delete(narudzbenica);
    }

    @Override
    public Narudzbenica save(Narudzbenica narudzbenica) {
        return narudzbenicaRepository.save(narudzbenica);
    }

}
