package com.poslovna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.domain.StavkeFakture;
import com.poslovna.dto.StavkaFaktureDTO;
import com.poslovna.service.FakturaService;
import com.poslovna.service.ProizvodService;
import com.poslovna.service.StavkaFaktureService;

@Controller
@RequestMapping(value="/stavkaFakture")
public class StavkaFaktureController {
	
	@Autowired
	private StavkaFaktureService stavkaService;
	
	@Autowired
	private FakturaService fakturaService;
	
	@Autowired
	private ProizvodService proizvodService;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(stavkaService.findAll(), HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody StavkaFaktureDTO dto){
		StavkeFakture sf = new StavkeFakture();
		sf.setFaktura(fakturaService.getById(dto.getFakturaId()));
		sf.setId(dto.getId());
		sf.setIznosPDV(dto.getIznosPDV());
		sf.setJedinicnaCena(dto.getJedinicnaCena());
		sf.setKolicina(dto.getKolicina());
		sf.setOsnovica(dto.getOsnovica());
		sf.setProizvod(proizvodService.getById(dto.getProizvodId()));
		sf.setRabat(dto.getRabat());
		sf.setRabatProcenat(dto.getRabatProcenat());
		sf.setStopaPDV(dto.getStopaPDV());
		sf.setUkupanIznos(dto.getUkupanIznos());
		StavkeFakture retVal = stavkaService.add(sf);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		StavkeFakture retVal = stavkaService.getById(id);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean delete = stavkaService.delete(id);
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody StavkaFaktureDTO dto) {
		StavkeFakture sf = stavkaService.getById(dto.getId());
		sf.setFaktura(fakturaService.getById(dto.getFakturaId()));
		sf.setIznosPDV(dto.getIznosPDV());
		sf.setJedinicnaCena(dto.getJedinicnaCena());
		sf.setKolicina(dto.getKolicina());
		sf.setOsnovica(dto.getOsnovica());
		sf.setProizvod(proizvodService.getById(dto.getProizvodId()));
		sf.setRabat(dto.getRabat());
		sf.setRabatProcenat(dto.getRabatProcenat());
		sf.setStopaPDV(dto.getStopaPDV());
		sf.setUkupanIznos(dto.getUkupanIznos());
		StavkeFakture retVal = stavkaService.add(sf);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
