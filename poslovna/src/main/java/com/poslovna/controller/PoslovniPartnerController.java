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

import com.poslovna.domain.PoslovniPartner;
import com.poslovna.dto.PoslovniPartnerDTO;
import com.poslovna.service.PoslovniPartnerService;

@Controller
@RequestMapping(value="/poslovniPartner")
public class PoslovniPartnerController {
	@Autowired
	private PoslovniPartnerService poslovniPartnerService;
	
	@RequestMapping(value="getPoslovniPartneri", method=RequestMethod.GET)
	public ResponseEntity<List<PoslovniPartner>> getPoslovniPartneri(){
		List<PoslovniPartner>poslovniPartneri = poslovniPartnerService.findAll();
		return new ResponseEntity<>(poslovniPartneri, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<PoslovniPartner> addPoslovniPartner(@RequestBody PoslovniPartnerDTO ppdto){
		PoslovniPartner pp = new PoslovniPartner();
		pp.setAdresa(ppdto.getAdresa());
		pp.setBrojRacuna(ppdto.getBrojRacuna());
		pp.setBrojTelefona(pp.getBrojTelefona());
		pp.setEmail(ppdto.getEmail());
		pp.setId(ppdto.getId());
		pp.setNaziv(ppdto.getNaziv());
			
		PoslovniPartner poslovniPartner = poslovniPartnerService.add(pp);
		return new ResponseEntity<>(poslovniPartner, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PoslovniPartner> getBusinessPartner(@PathVariable Long id) {
		PoslovniPartner pp = poslovniPartnerService.getById(id);
		if (pp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = poslovniPartnerService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<PoslovniPartner> edit(@RequestBody PoslovniPartnerDTO ppdto) {
		PoslovniPartner pp = poslovniPartnerService.getById(ppdto.getId());
		pp.setAdresa(ppdto.getAdresa());
		pp.setBrojRacuna(ppdto.getBrojRacuna());
		pp.setBrojTelefona(pp.getBrojTelefona());
		pp.setEmail(ppdto.getEmail());
		pp.setNaziv(ppdto.getNaziv());
		PoslovniPartner edited = poslovniPartnerService.add(pp);
		return new ResponseEntity<>(edited, HttpStatus.OK);
	}

}
