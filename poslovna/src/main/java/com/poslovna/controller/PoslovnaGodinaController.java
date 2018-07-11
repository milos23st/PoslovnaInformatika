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

import com.poslovna.domain.PoslovnaGodina;
import com.poslovna.dto.PoslovnaGodinaDTO;
import com.poslovna.service.PoslovnaGodinaService;
import com.poslovna.service.PreduzeceService;



@Controller
@RequestMapping(value="/poslovnaGodina")
public class PoslovnaGodinaController {

	@Autowired
	private PoslovnaGodinaService poslovnaGodinaService;
	
	@Autowired
	private PreduzeceService preduzeceService;
	
	@RequestMapping(value="getAll", method=RequestMethod.GET)
	public ResponseEntity<List<PoslovnaGodina>> getAll(){
		List<PoslovnaGodina> pg = poslovnaGodinaService.findAll();
		return new ResponseEntity<>(pg, HttpStatus.OK);		
	}	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> add(@RequestBody PoslovnaGodinaDTO pgdto){
		PoslovnaGodina pg = new PoslovnaGodina();
		pg.setGodina(pgdto.getGodina());
		pg.setId(pgdto.getId());
		pg.setPreduzece(preduzeceService.getById(pgdto.getId()));
		pg.setZakljucena(pgdto.isZakljucena());
		PoslovnaGodina retVal = poslovnaGodinaService.add(pg);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		PoslovnaGodina pg = poslovnaGodinaService.findOne(id);
		if (pg == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pg, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = poslovnaGodinaService.delete(id);
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> edit(@RequestBody PoslovnaGodinaDTO pgdto) {
		PoslovnaGodina pg = poslovnaGodinaService.findOne(pgdto.getId());
		pg.setGodina(pgdto.getGodina());
		pg.setZakljucena(pgdto.isZakljucena());
		pg.setPreduzece(preduzeceService.getById(pgdto.getPreduzeceId()));
		PoslovnaGodina retVal = poslovnaGodinaService.add(pg);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
