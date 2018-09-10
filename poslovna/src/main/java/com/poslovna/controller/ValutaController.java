package com.poslovna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poslovna.domain.JedinicaMere;
import com.poslovna.domain.Valuta;
import com.poslovna.dto.JedinicaMereDTO;
import com.poslovna.dto.ValutaDTO;
import com.poslovna.service.ValutaService;

@Controller
@RequestMapping(value="/valuta")
public class ValutaController {
	
	@Autowired
	private ValutaService service;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getCAll(){
		List<Valuta> v = service.findAll();
		return new ResponseEntity<>(v, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody ValutaDTO dto){
			
		Valuta va = new Valuta();
		va.setId(dto.getId());
		va.setNaziv(dto.getNaziv());
		va.setOznaka(dto.getOznaka());
		Valuta retVal= service.add(va);
		
		return new ResponseEntity<>(va, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		Valuta va = service.getById(id);
		if (va == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(va, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = service.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody ValutaDTO dto) {
		Valuta va = service.getById(dto.getId());
		va.setId(dto.getId());
		va.setNaziv(dto.getNaziv());
		va.setOznaka(dto.getOznaka());
		Valuta retVal= service.add(va);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

}
