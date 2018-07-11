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

import com.poslovna.domain.Preduzece;
import com.poslovna.dto.PreduzeceDTO;
import com.poslovna.service.PreduzeceService;


@Controller
@RequestMapping(value="/preduzece")
public class PreduzeceController {
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<?> getCAll(){
		List<Preduzece> p = preduzeceService.findAll();
		return new ResponseEntity<>(p, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody PreduzeceDTO dto){
			
		Preduzece p = new Preduzece();
		p.setAdresa(dto.getAdresa());
		p.setEmail(dto.getEmail());
		p.setId(dto.getId());
		p.setNazivPreduzeca(dto.getNazivPreduzeca());
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		Preduzece p = preduzeceService.getById(id);
		if (p == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = preduzeceService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody PreduzeceDTO dto) {
		Preduzece p = preduzeceService.getById(dto.getId());
		p.setAdresa(dto.getAdresa());
		p.setEmail(dto.getEmail());
		p.setNazivPreduzeca(dto.getNazivPreduzeca());
		Preduzece retVal = preduzeceService.add(p);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
